package com.losconfort.confort.service.impl;

import com.losconfort.confort.model.CarModel;
import com.losconfort.confort.repository.CarRepository;
import com.losconfort.confort.service.CarService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl extends DefaultServiceImpl<CarModel, Long, CarRepository>
    implements CarService {
  public CarServiceImpl(CarRepository repository) {
    super(repository);
  }
}
