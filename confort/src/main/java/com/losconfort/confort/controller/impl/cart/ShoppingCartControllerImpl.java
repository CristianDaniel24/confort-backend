package com.losconfort.confort.controller.impl.cart;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.losconfort.confort.controller.cart.ShoppingCartController;
import com.losconfort.confort.model.cart.ShoppingCartModel;
import com.losconfort.confort.service.cart.ShoppingCartService;
import com.losconfort.confortstarterrest.helper.DefaultControllerImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartControllerImpl
    extends DefaultControllerImpl<ShoppingCartModel, Long, ShoppingCartService>
    implements ShoppingCartController {
  public ShoppingCartControllerImpl(ShoppingCartService service) {
    super(service);
  }

  @Override
  @PostMapping("/confirm/{personId}")
  public ResponseEntity<ShoppingCartModel> confirmOrder(@PathVariable("personId") Long personId) {
    return ResponseEntity.ok(this.service.confirmOrder(personId));
  }

  @Override
  @GetMapping(path = "/client/{id}", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<ShoppingCartModel> getShoppingCart(@PathVariable("id") Long personId) {
    return ResponseEntity.ok(this.service.getShoppingCart(personId));
  }
}
