package com.losconfort.confort.controller.cart;

import com.losconfort.confort.model.cart.ShoppingCartProductModel;
import com.losconfort.confort.model.cart.ShoppingCartProductPK;
import com.losconfort.confortstarterrest.helper.DefaultController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface ShoppingCartProductController
    extends DefaultController<ShoppingCartProductModel, ShoppingCartProductPK> {

  ResponseEntity<Iterable<ShoppingCartProductModel>> shoppingCartProducts(
      @PathVariable Long clientId);

  ResponseEntity<ShoppingCartProductModel> delete(
      @PathVariable("clientId") Long clientId, @PathVariable("productId") Long productId);
}
