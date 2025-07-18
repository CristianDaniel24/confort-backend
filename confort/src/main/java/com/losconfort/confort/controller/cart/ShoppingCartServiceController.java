package com.losconfort.confort.controller.cart;

import com.losconfort.confort.model.cart.ShoppingCartServiceModel;
import com.losconfort.confort.model.cart.ShoppingCartServicePK;
import com.losconfort.confortstarterrest.helper.DefaultController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface ShoppingCartServiceController
    extends DefaultController<ShoppingCartServiceModel, ShoppingCartServicePK> {

  ResponseEntity<Iterable<ShoppingCartServiceModel>> shoppingCartProducts(Long clientId);

  ResponseEntity<ShoppingCartServiceModel> delete(Long clientId, Long serviceId);
}
