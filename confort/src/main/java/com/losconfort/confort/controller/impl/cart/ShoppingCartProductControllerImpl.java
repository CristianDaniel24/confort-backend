package com.losconfort.confort.controller.impl.cart;

import com.losconfort.confort.controller.cart.ShoppingCartProductController;
import com.losconfort.confort.model.cart.ShoppingCartProductModel;
import com.losconfort.confort.model.cart.ShoppingCartProductPK;
import com.losconfort.confort.service.cart.ShoppingCartProductService;
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
