package com.losconfort.confort.controller.car;

import com.losconfort.confort.model.car.CarModel;
import com.losconfort.confortstarterrest.helper.DefaultController;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CarController extends DefaultController<CarModel, Long> {

  ResponseEntity<List<CarModel>> getCarByPersonId(Long personId);
}
