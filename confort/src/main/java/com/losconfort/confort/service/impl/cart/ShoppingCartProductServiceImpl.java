package com.losconfort.confort.service.impl.cart;

import com.losconfort.confort.model.cart.ShoppingCartModel;
import com.losconfort.confort.model.cart.ShoppingCartProductModel;
import com.losconfort.confort.model.cart.ShoppingCartProductPK;
import com.losconfort.confort.model.provider.ProductModel;
import com.losconfort.confort.repository.ShoppingCartProductRepository;
import com.losconfort.confort.service.cart.ShoppingCartProductService;
import com.losconfort.confort.service.cart.ShoppingCartService;
import com.losconfort.confort.service.provider.ProductService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
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

    ShoppingCartProductPK pk = new ShoppingCartProductPK();
    pk.setShoppingCart(getShoppingCart(model));
    pk.setProduct(getProduct(model));
    model.setId(pk);

    return repository.save(model);
  }

  private ShoppingCartModel getShoppingCart(ShoppingCartProductModel model) {
    Long shoppingCartId =
        model.getId() != null && model.getId().getShoppingCart() != null
            ? model.getId().getShoppingCart().getId()
            : null;
    if (shoppingCartId == null) {
      throw new RuntimeException("El ID de shoppingCart es null");
    }
    return shoppingCartService.read(shoppingCartId);
  }

  private ProductModel getProduct(ShoppingCartProductModel model) {
    Long productId =
        model.getId() != null && model.getId().getProduct() != null
            ? model.getId().getProduct().getId()
            : null;
    if (productId == null) {
      throw new RuntimeException("El ID de Product es null");
    }
    return productService.read(productId);
  }
}
