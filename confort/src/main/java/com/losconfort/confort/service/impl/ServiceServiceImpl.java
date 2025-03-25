package com.losconfort.confort.service.impl;

import com.losconfort.confort.model.ServiceModel;
import com.losconfort.confort.repository.ServiceRepository;
import com.losconfort.confort.service.ServiceService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiceImpl extends DefaultServiceImpl<ServiceModel, Long, ServiceRepository>
    implements ServiceService {
  public ServiceServiceImpl(ServiceRepository repository) {
    super(repository);
  }
}
