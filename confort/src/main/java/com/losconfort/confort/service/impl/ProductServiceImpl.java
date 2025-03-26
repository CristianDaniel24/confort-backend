package com.losconfort.confort.service.impl;

import com.losconfort.confort.model.ProductModel;
import com.losconfort.confort.repository.ProductRepository;
import com.losconfort.confort.service.ProductService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends DefaultServiceImpl<ProductModel, Long, ProductRepository>
    implements ProductService {
  public ProductServiceImpl(ProductRepository repository) {
    super(repository);
  }
}
