package com.losconfort.confort.repository.car;

import com.losconfort.confort.model.car.CarModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends DefaultRepository<CarModel, Long> {}
