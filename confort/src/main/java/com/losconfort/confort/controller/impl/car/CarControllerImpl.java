package com.losconfort.confort.controller.impl.car;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.losconfort.confort.controller.car.CarController;
import com.losconfort.confort.model.car.CarModel;
import com.losconfort.confort.service.car.CarService;
import com.losconfort.confortstarterrest.helper.DefaultControllerImpl;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarControllerImpl extends DefaultControllerImpl<CarModel, Long, CarService>
    implements CarController {
  public CarControllerImpl(CarService service) {
    super(service);
  }

  @Override
  @GetMapping(path = "/client/{id}", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<List<CarModel>> getCarByPersonId(@PathVariable("id") Long personId) {
    return ResponseEntity.ok(this.service.getCarByPersonId(personId));
  }
}
