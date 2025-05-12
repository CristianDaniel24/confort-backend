package com.losconfort.confort.controller.impl.provider;

import com.losconfort.confort.controller.provider.TypeProductController;
import com.losconfort.confort.model.provider.TypeProductModel;
import com.losconfort.confort.service.provider.TypeProductService;
import com.losconfort.confortstarterrest.helper.DefaultControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/type-product")
public class TypeProductControllerImpl
    extends DefaultControllerImpl<TypeProductModel, Long, TypeProductService>
    implements TypeProductController {

  public TypeProductControllerImpl(TypeProductService service) {
    super(service);
  }
}
