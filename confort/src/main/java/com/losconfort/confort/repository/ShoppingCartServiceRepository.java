package com.losconfort.confort.repository;

import com.losconfort.confort.model.ShoppingCartServiceModel;
import com.losconfort.confort.model.ShoppingCartServicePK;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartServiceRepository
    extends DefaultRepository<ShoppingCartServiceModel, ShoppingCartServicePK> {}
