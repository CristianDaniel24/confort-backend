package com.losconfort.confort.controller.cart;

import com.losconfort.confort.model.cart.ShoppingCartModel;
import com.losconfort.confortstarterrest.helper.DefaultController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface ShoppingCartController extends DefaultController<ShoppingCartModel, Long> {
  @PostMapping("/confirm/{clientId}")
  ResponseEntity<ShoppingCartModel> confirmOrder(@PathVariable Long clientId);
}
