package com.losconfort.confort.repository.cart;

import com.losconfort.confort.model.cart.ShoppingCartProductModel;
import com.losconfort.confort.model.cart.ShoppingCartServiceModel;
import com.losconfort.confort.model.cart.ShoppingCartServicePK;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartServiceRepository
    extends DefaultRepository<ShoppingCartServiceModel, ShoppingCartServicePK> {
  List<ShoppingCartServiceModel> findByShoppingCart_Id(Long shoppingCartId);
}
