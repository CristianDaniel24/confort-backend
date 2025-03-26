package com.losconfort.confort.controller.impl;

import com.losconfort.confort.controller.ProductController;
import com.losconfort.confort.model.ProductModel;
import com.losconfort.confort.service.ProductService;
import com.losconfort.confortstarterrest.helper.DefaultControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductControllerImpl extends DefaultControllerImpl<ProductModel, Long, ProductService>
    implements ProductController {
  public ProductControllerImpl(ProductService service) {
    super(service);
  }
}
