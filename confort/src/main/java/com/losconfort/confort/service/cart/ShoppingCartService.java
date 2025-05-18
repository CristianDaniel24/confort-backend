package com.losconfort.confort.service.cart;

import com.losconfort.confort.model.cart.ShoppingCartModel;
import com.losconfort.confortstarterrest.helper.DefaultService;

public interface ShoppingCartService extends DefaultService<ShoppingCartModel, Long> {
  ShoppingCartModel getShoppingCartByPersonId(Long personId);

  ShoppingCartModel confirmOrder(Long personId);

  ShoppingCartModel getShoppingCart(Long personId);

  ShoppingCartModel getShoppingCartId(Long shoppingCartId);
}
