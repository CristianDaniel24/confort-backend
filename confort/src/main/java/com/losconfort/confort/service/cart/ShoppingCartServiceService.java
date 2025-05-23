package com.losconfort.confort.service.cart;

import com.losconfort.confort.model.cart.ShoppingCartServiceModel;
import com.losconfort.confort.model.cart.ShoppingCartServicePK;
import com.losconfort.confortstarterrest.helper.DefaultService;
import java.util.List;

public interface ShoppingCartServiceService
    extends DefaultService<ShoppingCartServiceModel, ShoppingCartServicePK> {
  List<ShoppingCartServiceModel> findByClientId(Long id);

  ShoppingCartServiceModel delete(Long clientId, Long serviceId);
}
