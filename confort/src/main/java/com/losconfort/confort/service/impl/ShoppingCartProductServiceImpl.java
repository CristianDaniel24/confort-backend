package com.losconfort.confort.service.impl;

import com.losconfort.confort.model.*;
import com.losconfort.confort.model.cart.ShoppingCartModel;
import com.losconfort.confort.model.provider.ProductModel;
import com.losconfort.confort.repository.ShoppingCartProductRepository;
import com.losconfort.confort.repository.cart.ShoppingCartRepository;
import com.losconfort.confort.repository.provider.ProductRepository;
import com.losconfort.confort.service.ShoppingCartProductService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShoppingCartProductServiceImpl
    extends DefaultServiceImpl<
        ShoppingCartProductModel, ShoppingCartProductPK, ShoppingCartProductRepository>
    implements ShoppingCartProductService {

  private final ShoppingCartRepository shoppingCartRepository;
  private final ProductRepository productRepository;

  public ShoppingCartProductServiceImpl(
      ShoppingCartProductRepository repository,
      ShoppingCartRepository shoppingCartRepository,
      ProductRepository productRepository) {
    super(repository);
    this.shoppingCartRepository = shoppingCartRepository;
    this.productRepository = productRepository;
  }

  @Override
  @Transactional
  public ShoppingCartProductModel create(ShoppingCartProductModel model) {
    Long shoppingCartId =
        model.getId() != null && model.getId().getShoppingCart() != null
            ? model.getId().getShoppingCart().getId()
            : null;

    Long productId =
        model.getId() != null && model.getId().getProduct() != null
            ? model.getId().getProduct().getId()
            : null;

    if (shoppingCartId == null || productId == null) {
      throw new RuntimeException("ID de shoppingCart o Product es null");
    }

    ShoppingCartModel shoppingCart =
        shoppingCartRepository
            .findById(shoppingCartId)
            .orElseThrow(() -> new RuntimeException("ShoppingCart no encontrado"));

    ProductModel product =
        productRepository
            .findById(productId)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

    ShoppingCartProductPK pk = new ShoppingCartProductPK();
    pk.setShoppingCart(shoppingCart);
    pk.setProduct(product);
    model.setId(pk);

    return repository.save(model);
  }
}
