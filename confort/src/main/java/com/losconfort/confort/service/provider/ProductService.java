package com.losconfort.confort.service.provider;

import com.losconfort.confort.model.provider.ProductModel;
import com.losconfort.confortstarterrest.helper.DefaultService;

public interface ProductService extends DefaultService<ProductModel, Long> {
  ProductModel findById(Long id);
}
