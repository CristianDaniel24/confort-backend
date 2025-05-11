package com.losconfort.confort.repository.cart;

import com.losconfort.confort.model.cart.ShoppingCartProductModel;
import com.losconfort.confort.model.cart.ShoppingCartProductPK;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartProductRepository
    extends DefaultRepository<ShoppingCartProductModel, ShoppingCartProductPK> {
  List<ShoppingCartProductModel> findById_ShoppingCart_Client_Id(Long clientId);
}
