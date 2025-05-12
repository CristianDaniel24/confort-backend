package com.losconfort.confort.service.impl;

import com.losconfort.confort.model.RolModel;
import com.losconfort.confort.repository.RolRepository;
import com.losconfort.confort.service.RolService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl extends DefaultServiceImpl<RolModel, Long, RolRepository>
    implements RolService {
  public RolServiceImpl(RolRepository repository) {
    super(repository);
  }
}
