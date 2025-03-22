package com.losconfort.confort.service.impl;

import com.losconfort.confort.model.TypeCarModel;
import com.losconfort.confort.repository.TypeCarRepository;
import com.losconfort.confort.service.TypeCarService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TypeCarServiceImpl extends DefaultServiceImpl<TypeCarModel, Long, TypeCarRepository>
    implements TypeCarService {

  public TypeCarServiceImpl(TypeCarRepository repository) {
    super(repository);
  }
}
