package com.losconfort.confort.repository.cart;

import com.losconfort.confort.model.cart.ShoppingCartModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends DefaultRepository<ShoppingCartModel, Long> {}
