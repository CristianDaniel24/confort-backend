package com.losconfort.confort.repository.cart;

import com.losconfort.confort.model.cart.ShoppingCartModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends DefaultRepository<ShoppingCartModel, Long> {
  @Query(
      "SELECT shoppingCart FROM ShoppingCartModel shoppingCart "
          + "JOIN shoppingCart.client client "
          + "JOIN client.person person "
          + "WHERE person.id = :personId AND shoppingCart.status = 'ACTIVO'")
  Optional<ShoppingCartModel> findActiveShoppingCartByPersonId(@Param("personId") Long personId);
}
