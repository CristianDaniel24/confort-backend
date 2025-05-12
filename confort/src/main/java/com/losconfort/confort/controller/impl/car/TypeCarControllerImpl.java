package com.losconfort.confort.controller.impl.car;

import com.losconfort.confort.controller.car.TypeCarController;
import com.losconfort.confort.model.car.TypeCarModel;
import com.losconfort.confort.service.car.TypeCarService;
import com.losconfort.confortstarterrest.helper.DefaultControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/types-car")
public class TypeCarControllerImpl extends DefaultControllerImpl<TypeCarModel, Long, TypeCarService>
    implements TypeCarController {

  public TypeCarControllerImpl(TypeCarService service) {
    super(service);
  }
}
