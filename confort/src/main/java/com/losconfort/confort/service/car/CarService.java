package com.losconfort.confort.service.car;

import com.losconfort.confort.model.car.CarModel;
import com.losconfort.confortstarterrest.helper.DefaultService;
import java.util.List;

public interface CarService extends DefaultService<CarModel, Long> {

    List<CarModel> getCarByPersonId(Long personId);
}
