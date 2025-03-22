package com.losconfort.confort.repository;

import com.losconfort.confort.model.CarModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends DefaultRepository<CarModel, Long> {}
