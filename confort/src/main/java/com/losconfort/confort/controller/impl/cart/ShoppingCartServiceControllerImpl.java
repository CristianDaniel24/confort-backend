package com.losconfort.confort.controller.impl.cart;

import com.losconfort.confort.controller.cart.ShoppingCartServiceController;
import com.losconfort.confort.model.cart.ShoppingCartServiceModel;
import com.losconfort.confort.model.cart.ShoppingCartServicePK;
import com.losconfort.confort.service.cart.ShoppingCartServiceService;
import com.losconfort.confortstarterrest.helper.DefaultControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoppingCart-service")
public class ShoppingCartServiceControllerImpl
    extends DefaultControllerImpl<
        ShoppingCartServiceModel, ShoppingCartServicePK, ShoppingCartServiceService>
    implements ShoppingCartServiceController {
  public ShoppingCartServiceControllerImpl(ShoppingCartServiceService service) {
    super(service);
  }
}
