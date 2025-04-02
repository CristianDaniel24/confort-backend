package com.losconfort.confort.service.impl.provider;

import com.losconfort.confort.model.provider.ProductModel;
import com.losconfort.confort.repository.provider.ProductRepository;
import com.losconfort.confort.service.provider.ProductService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends DefaultServiceImpl<ProductModel, Long, ProductRepository>
    implements ProductService {
  public ProductServiceImpl(ProductRepository repository) {
    super(repository);
  }
}
