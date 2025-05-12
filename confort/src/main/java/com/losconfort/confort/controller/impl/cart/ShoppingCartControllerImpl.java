package com.losconfort.confort.controller.impl.cart;

import com.losconfort.confort.controller.cart.ShoppingCartController;
import com.losconfort.confort.model.cart.ShoppingCartModel;
import com.losconfort.confort.service.cart.ShoppingCartService;
import com.losconfort.confortstarterrest.helper.DefaultControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartControllerImpl
    extends DefaultControllerImpl<ShoppingCartModel, Long, ShoppingCartService>
    implements ShoppingCartController {
  public ShoppingCartControllerImpl(ShoppingCartService service) {
    super(service);
  }
}
