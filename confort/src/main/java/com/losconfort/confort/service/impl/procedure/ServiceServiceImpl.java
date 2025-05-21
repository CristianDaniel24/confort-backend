package com.losconfort.confort.service.impl.procedure;

import com.losconfort.confort.enums.ServiceEnum;
import com.losconfort.confort.model.procedure.ServiceModel;
import com.losconfort.confort.repository.procedure.ServiceRepository;
import com.losconfort.confort.service.procedure.ServiceService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiceImpl extends DefaultServiceImpl<ServiceModel, Long, ServiceRepository>
    implements ServiceService {

  public ServiceServiceImpl(ServiceRepository repository) {
    super(repository);
  }

  @Override
  public ServiceModel create(ServiceModel model) {
    model.setStatus(ServiceEnum.CREADO);
    return super.create(model);
  }
}
