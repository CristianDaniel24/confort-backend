package com.losconfort.confort.repository.cart;

import com.losconfort.confort.model.cart.ShoppingCartProductModel;
import com.losconfort.confort.model.cart.ShoppingCartProductPK;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartProductRepository
    extends DefaultRepository<ShoppingCartProductModel, ShoppingCartProductPK> {
  
  List<ShoppingCartProductModel> findByShoppingCart_Id(Long shoppingCartId);

  @Modifying
  @Query("DELETE FROM ShoppingCartProductModel p WHERE p.shoppingCart.id = :cartId")
  void deleteAllByShoppingCartId(@Param("cartId") Long cartId);
}
