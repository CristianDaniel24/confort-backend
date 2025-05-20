package com.losconfort.confort.service.impl.car;

import com.losconfort.confort.model.car.CarModel;
import com.losconfort.confort.repository.car.CarRepository;
import com.losconfort.confort.service.car.CarService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl extends DefaultServiceImpl<CarModel, Long, CarRepository>
    implements CarService {
  public CarServiceImpl(CarRepository repository) {
    super(repository);
  }

  @Override
  public List<CarModel> getCarByPersonId(Long personId) {
    return this.repository.findAllByPersonId(personId);
  }
}
