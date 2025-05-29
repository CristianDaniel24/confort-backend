package com.losconfort.confort.service.procedure;

import com.losconfort.confort.model.procedure.ServiceModel;
import com.losconfort.confortstarterrest.helper.DefaultService;

public interface ServiceService extends DefaultService<ServiceModel, Long> {
  ServiceModel findById(Long id);

  Long pendingOrders();

  ServiceModel newService();
}
