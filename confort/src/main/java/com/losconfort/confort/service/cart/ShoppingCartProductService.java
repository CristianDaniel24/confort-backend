package com.losconfort.confort.service.cart;

import com.losconfort.confort.model.cart.ShoppingCartProductModel;
import com.losconfort.confort.model.cart.ShoppingCartProductPK;
import com.losconfort.confortstarterrest.helper.DefaultService;
import java.util.List;

public interface ShoppingCartProductService
    extends DefaultService<ShoppingCartProductModel, ShoppingCartProductPK> {

  List<ShoppingCartProductModel> findByClientId(Long id);

  ShoppingCartProductModel delete(Long clientId, Long productId);
}
