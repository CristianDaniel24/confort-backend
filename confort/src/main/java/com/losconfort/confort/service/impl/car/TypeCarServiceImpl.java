package com.losconfort.confort.service.impl.car;

import com.losconfort.confort.model.car.TypeCarModel;
import com.losconfort.confort.repository.car.TypeCarRepository;
import com.losconfort.confort.service.car.TypeCarService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TypeCarServiceImpl extends DefaultServiceImpl<TypeCarModel, Long, TypeCarRepository>
    implements TypeCarService {

  public TypeCarServiceImpl(TypeCarRepository repository) {
    super(repository);
  }
}
