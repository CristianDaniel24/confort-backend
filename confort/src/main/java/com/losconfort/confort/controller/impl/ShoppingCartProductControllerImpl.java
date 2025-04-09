package com.losconfort.confort.controller.impl;

import com.losconfort.confort.controller.ShoppingCartProductController;
import com.losconfort.confort.model.ShoppingCartProductModel;
import com.losconfort.confort.model.ShoppingCartProductPK;
import com.losconfort.confort.service.ShoppingCartProductService;
import com.losconfort.confortstarterrest.helper.DefaultControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoppingCart-product")
public class ShoppingCartProductControllerImpl
    extends DefaultControllerImpl<
        ShoppingCartProductModel, ShoppingCartProductPK, ShoppingCartProductService>
    implements ShoppingCartProductController {
  public ShoppingCartProductControllerImpl(ShoppingCartProductService service) {
    super(service);
  }
}
