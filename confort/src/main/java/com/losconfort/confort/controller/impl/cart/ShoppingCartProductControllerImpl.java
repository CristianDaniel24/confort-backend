package com.losconfort.confort.controller.impl.cart;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.losconfort.confort.controller.cart.ShoppingCartProductController;
import com.losconfort.confort.model.cart.ShoppingCartProductModel;
import com.losconfort.confort.model.cart.ShoppingCartProductPK;
import com.losconfort.confort.service.cart.ShoppingCartProductService;
import com.losconfort.confortstarterrest.helper.DefaultControllerImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shoppingCart-product")
public class ShoppingCartProductControllerImpl
    extends DefaultControllerImpl<
        ShoppingCartProductModel, ShoppingCartProductPK, ShoppingCartProductService>
    implements ShoppingCartProductController {

  public ShoppingCartProductControllerImpl(ShoppingCartProductService service) {
    super(service);
  }

  @Override
  @GetMapping(path = "/client/{id}", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Iterable<ShoppingCartProductModel>> shoppingCartProducts(
      @PathVariable("id") Long clientId) {
    return ResponseEntity.ok(this.service.findByClientId(clientId));
  }

  @Override
  @DeleteMapping(path = "/client/{clientId}/product/{productId}")
  public ResponseEntity<ShoppingCartProductModel> delete(
      @PathVariable("clientId") Long clientId, @PathVariable("productId") Long productId) {
    var shoppingCartProduct = this.service.delete(clientId, productId);
    return ResponseEntity.ok(shoppingCartProduct);
  }
}
