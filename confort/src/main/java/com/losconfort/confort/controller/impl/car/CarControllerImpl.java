package com.losconfort.confort.controller.impl.car;

import com.losconfort.confort.controller.car.CarController;
import com.losconfort.confort.model.car.CarModel;
import com.losconfort.confort.service.car.CarService;
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
