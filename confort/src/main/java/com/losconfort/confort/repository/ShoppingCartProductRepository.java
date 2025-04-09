package com.losconfort.confort.repository;

import com.losconfort.confort.model.ShoppingCartProductModel;
import com.losconfort.confort.model.ShoppingCartProductPK;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartProductRepository
    extends DefaultRepository<ShoppingCartProductModel, ShoppingCartProductPK> {}
