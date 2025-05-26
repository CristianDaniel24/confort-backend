package com.losconfort.confort.controller.impl.cart;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.losconfort.confort.controller.cart.ShoppingCartServiceController;
import com.losconfort.confort.model.cart.ShoppingCartServiceModel;
import com.losconfort.confort.model.cart.ShoppingCartServicePK;
import com.losconfort.confort.service.cart.ShoppingCartServiceService;
import com.losconfort.confortstarterrest.helper.DefaultControllerImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shoppingCart-service")
public class ShoppingCartServiceControllerImpl
    extends DefaultControllerImpl<
        ShoppingCartServiceModel, ShoppingCartServicePK, ShoppingCartServiceService>
    implements ShoppingCartServiceController {
  public ShoppingCartServiceControllerImpl(ShoppingCartServiceService service) {
    super(service);
  }

  @Override
  @GetMapping(path = "/client/{id}", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Iterable<ShoppingCartServiceModel>> shoppingCartProducts(
      @PathVariable("id") Long clientId) {
    return ResponseEntity.ok(this.service.findByClientId(clientId));
  }

  @Override
  @DeleteMapping(path = "/client/{clientId}/service/{serviceId}")
  public ResponseEntity<ShoppingCartServiceModel> delete(
      @PathVariable("clientId") Long clientId, @PathVariable("serviceId") Long serviceId) {
    var shoppingCartProduct = this.service.delete(clientId, serviceId);
    return ResponseEntity.ok(shoppingCartProduct);
  }
}
