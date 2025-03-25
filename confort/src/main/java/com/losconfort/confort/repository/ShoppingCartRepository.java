package com.losconfort.confort.repository;

import com.losconfort.confort.model.ShoppingCartModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends DefaultRepository<ShoppingCartModel, Long> {}
