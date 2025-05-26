package com.losconfort.confort.service.impl.cart;

import com.losconfort.confort.enums.ShoppingCartEnum;
import com.losconfort.confort.model.ClientModel;
import com.losconfort.confort.model.cart.ShoppingCartModel;
import com.losconfort.confort.model.payment.BillModel;
import com.losconfort.confort.repository.ClientRepository;
import com.losconfort.confort.repository.cart.ShoppingCartRepository;
import com.losconfort.confort.service.cart.ShoppingCartService;
import com.losconfort.confort.service.payment.BillService;
import com.losconfort.confort.service.provider.ProductService;
import com.losconfort.confortstarterrest.exception.ResourceNotFoundException;
import com.losconfort.confortstarterrest.exception.ShoppingCartException;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShoppingCartServiceImpl
    extends DefaultServiceImpl<ShoppingCartModel, Long, ShoppingCartRepository>
    implements ShoppingCartService {

  private final ClientRepository clientRepository;
  private final ProductService productService;
  private final BillService billService;

  public ShoppingCartServiceImpl(
      ShoppingCartRepository repository,
      ClientRepository clientRepository,
      ProductService productService,
      BillService billService) {
    super(repository);
    this.clientRepository = clientRepository;
    this.productService = productService;
    this.billService = billService;
  }

  @Override
  public ShoppingCartModel getShoppingCartByPersonId(Long personId) {

    Optional<ShoppingCartModel> shoppingCart =
        this.repository.findActiveShoppingCartByPersonId(personId);

    if (shoppingCart.isPresent()) {
      return shoppingCart.get();
    } else {
      ClientModel client =
          this.clientRepository
              .findByPersonId(personId)
              .orElseThrow(() -> new ResourceNotFoundException("El cliente no se encontro!"));

      ShoppingCartModel newCart = new ShoppingCartModel();
      newCart.setClient(client);
      newCart.setStatus(ShoppingCartEnum.ACTIVO);
      return this.repository.save(newCart);
    }
  }

  @Override
  @Transactional
  public ShoppingCartModel confirmOrder(Long personId) {
    ShoppingCartModel shoppingCart =
        this.repository
            .findActiveShoppingCartByPersonId(personId)
            .orElseThrow(
                () -> new ShoppingCartException("Ocurrio un error con el carrito de compras!"));

    // Validacion del Stock
    shoppingCart
        .getShoppingCartProduct()
        .forEach(
            item -> {
              var product = item.getId().getProduct();
              var cantidadComprada = item.getAmount();

              if (cantidadComprada == null || cantidadComprada <= 0) {
                throw new ShoppingCartException(
                    "La cantidad del producto " + product.getName() + " no es válida.");
              }

              if (product.getStock() < cantidadComprada) {
                throw new ShoppingCartException(
                    "No hay suficiente stock para el producto: "
                        + product.getName()
                        + ". Disponible: "
                        + product.getStock()
                        + ", requerido: "
                        + cantidadComprada);
              }
            });

    // Descuento del stock
    shoppingCart
        .getShoppingCartProduct()
        .forEach(
            item -> {
              var product = item.getId().getProduct();
              var quantityPurchased = item.getAmount();
              Long newStock = product.getStock() - quantityPurchased;
              product.setStock(newStock);
              this.productService.updateStock(product.getId(), newStock);
            });

    // Actualizar y guardar el carrito
    shoppingCart.setStatus(ShoppingCartEnum.CONFIRMADO);
    shoppingCart = this.repository.save(shoppingCart);

    // Creacion de la factura
    BillModel bill = new BillModel();
    bill.setDate(Timestamp.valueOf(LocalDateTime.now()));
    bill.setCostTotal(this.costTotal(shoppingCart));
    bill.setShoppingCart(shoppingCart);
    this.billService.create(bill);

    return shoppingCart;
  }

  private Double costTotal(ShoppingCartModel shoppingCart) {
    double productsTotal =
        shoppingCart.getShoppingCartProduct().stream()
            .mapToDouble(
                item -> {
                  Double price = item.getId().getProduct().getCost();
                  Integer amount = item.getAmount();
                  return price * (amount != null ? amount : 0);
                })
            .sum();

    double servicesTotal =
        shoppingCart.getShoppingCartServices().stream()
            .mapToDouble(
                item -> {
                  Double servicePrice = item.getService().getProcedure().getPrice();
                  Integer serviceAmount = item.getAmount();
                  return servicePrice * (serviceAmount != null ? serviceAmount : 0);
                })
            .sum();

    return productsTotal + servicesTotal;
  }

  @Override
  public ShoppingCartModel getShoppingCartId(Long shoppingCartId) {
    return this.repository.findById(shoppingCartId).orElse(new ShoppingCartModel());
  }

  @Override
  public ShoppingCartModel getShoppingCart(Long personId) {
    return this.repository
        .findActiveShoppingCartByPersonId(personId)
        .orElse(new ShoppingCartModel());
  }
}
