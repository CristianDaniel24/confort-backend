package com.losconfort.confort.repository.provider;

import com.losconfort.confort.model.provider.ProductModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends DefaultRepository<ProductModel, Long> {}
