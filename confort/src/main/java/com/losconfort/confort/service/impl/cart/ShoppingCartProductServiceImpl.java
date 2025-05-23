package com.losconfort.confort.service.impl.cart;

import com.losconfort.confort.model.cart.ShoppingCartModel;
import com.losconfort.confort.model.cart.ShoppingCartProductModel;
import com.losconfort.confort.model.cart.ShoppingCartProductPK;
import com.losconfort.confort.model.provider.ProductModel;
import com.losconfort.confort.repository.cart.ShoppingCartProductRepository;
import com.losconfort.confort.service.cart.ShoppingCartProductService;
import com.losconfort.confort.service.cart.ShoppingCartService;
import com.losconfort.confort.service.provider.ProductService;
import com.losconfort.confortstarterrest.exception.ShoppingCartException;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShoppingCartProductServiceImpl
    extends DefaultServiceImpl<
        ShoppingCartProductModel, ShoppingCartProductPK, ShoppingCartProductRepository>
    implements ShoppingCartProductService {

  private final ShoppingCartService shoppingCartService;
  private final ProductService productService;

  public ShoppingCartProductServiceImpl(
      ShoppingCartProductRepository repository,
      ShoppingCartService shoppingCartService,
      ProductService productService) {
    super(repository);
    this.shoppingCartService = shoppingCartService;
    this.productService = productService;
  }

  @Override
  @Transactional
  public ShoppingCartProductModel create(ShoppingCartProductModel model) {

    ShoppingCartModel shoppingCart =
        this.shoppingCartService.getShoppingCartByPersonId(
            model.getId().getShoppingCart().getClient().getPerson().getId());

    ProductModel product = getProduct(model);

    if (product.getStock() == null || product.getStock() <= 0) {
      throw new ShoppingCartException(
          "No hay una cantidad disponible para este producto o es nula");
    }

    ShoppingCartProductPK pk = new ShoppingCartProductPK(shoppingCart, product);
    Optional<ShoppingCartProductModel> existing = repository.findById(pk);

    if (existing.isPresent()) {
      ShoppingCartProductModel existingItem = existing.get();
      existingItem.setAmount(existingItem.getAmount() + 1);
      return repository.save(existingItem);
    }

    model.setId(pk);
    model.setAmount(1);
    return repository.save(model);
  }

  private ProductModel getProduct(ShoppingCartProductModel model) {
    Long productId =
        model.getId() != null && model.getId().getProduct() != null
            ? model.getId().getProduct().getId()
            : null;
    if (productId == null) {
      throw new RuntimeException("El ID de producto es null");
    }
    return productService.read(productId);
  }

  // Ahora este metodo permite obtener los productos solo del carrito activo
  @Override
  public List<ShoppingCartProductModel> findByClientId(Long clientId) {
    ShoppingCartModel activeCart = this.shoppingCartService.getShoppingCartByPersonId(clientId);
    return this.repository.findByShoppingCart_Id(activeCart.getId());
  }

  @Override
  public ShoppingCartProductModel delete(Long clientId, Long productId) {
    ShoppingCartModel shoppingCart = this.shoppingCartService.getShoppingCartByPersonId(clientId);

    ProductModel product = this.productService.findById(productId);

    ShoppingCartProductPK pk = new ShoppingCartProductPK(shoppingCart, product);

    ShoppingCartProductModel cartProduct =
        repository
            .findById(pk)
            .orElseThrow(() -> new ShoppingCartException("El producto no esta en el carrito"));
    repository.deleteById(pk);

    return cartProduct;
  }
}
