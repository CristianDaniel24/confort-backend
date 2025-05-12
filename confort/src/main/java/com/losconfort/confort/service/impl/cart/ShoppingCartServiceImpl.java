package com.losconfort.confort.service.impl.cart;

import com.losconfort.confort.enums.ShoppingCartEnum;
import com.losconfort.confort.model.ClientModel;
import com.losconfort.confort.model.cart.ShoppingCartModel;
import com.losconfort.confort.model.payment.BillModel;
import com.losconfort.confort.repository.ClientRepository;
import com.losconfort.confort.repository.cart.ShoppingCartRepository;
import com.losconfort.confort.service.cart.ShoppingCartService;
import com.losconfort.confort.service.payment.BillService;
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
  private final BillService bill;

  public ShoppingCartServiceImpl(
      ShoppingCartRepository repository, ClientRepository clientRepository, BillService bill) {
    super(repository);
    this.clientRepository = clientRepository;
    this.bill = bill;
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
    Optional<ShoppingCartModel> shoppingCart =
        this.repository.findActiveShoppingCartByPersonId(personId);

    if (shoppingCart.isPresent()) {
      shoppingCart.get().setStatus(ShoppingCartEnum.CONFIRMADO);

      BillModel bill = new BillModel();
      bill.setDate(Timestamp.valueOf(LocalDateTime.now()));
      bill.setCostTotal(this.costTotal(shoppingCart.get()));
      bill.setShoppingCart(shoppingCart.get());
      this.bill.create(bill);
    } else {
      throw new ShoppingCartException("Ocurrio un error con el carrito de compras!");
    }
    return shoppingCart.get();
  }

  private Double costTotal(ShoppingCartModel shoppingCart) {
    return shoppingCart.getShoppingCartProduct().stream()
        .mapToDouble(
            item -> {
              Double price = item.getId().getProduct().getCost();
              Integer amount = item.getAmount();
              return price * amount;
            })
        .sum();
  }
}
