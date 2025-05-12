package com.losconfort.confort.controller.impl.provider;

import com.losconfort.confort.controller.provider.ProductController;
import com.losconfort.confort.model.provider.ProductModel;
import com.losconfort.confort.service.provider.ProductService;
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
