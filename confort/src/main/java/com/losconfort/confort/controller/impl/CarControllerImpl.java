package com.losconfort.confort.controller.impl;

import com.losconfort.confort.controller.CarController;
import com.losconfort.confort.model.CarModel;
import com.losconfort.confort.service.CarService;
import com.losconfort.confortstarterrest.helper.DefaultControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarControllerImpl extends DefaultControllerImpl<CarModel, Long, CarService>
    implements CarController {
  public CarControllerImpl(CarService service) {
    super(service);
  }
}
