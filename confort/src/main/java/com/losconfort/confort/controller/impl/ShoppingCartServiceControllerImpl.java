package com.losconfort.confort.controller.impl;

import com.losconfort.confort.controller.ShoppingCartServiceController;
import com.losconfort.confort.model.ShoppingCartServiceModel;
import com.losconfort.confort.model.ShoppingCartServicePK;
import com.losconfort.confort.service.ShoppingCartServiceService;
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
