package com.losconfort.confort.repository;

import com.losconfort.confort.model.ProductModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends DefaultRepository<ProductModel, Long> {}
