package com.losconfort.confort.repository.car;

import com.losconfort.confort.model.car.TypeCarModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeCarRepository extends DefaultRepository<TypeCarModel, Long> {}
