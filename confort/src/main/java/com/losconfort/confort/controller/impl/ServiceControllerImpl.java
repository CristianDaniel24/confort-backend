package com.losconfort.confort.controller.impl;

import com.losconfort.confort.controller.ServiceController;
import com.losconfort.confort.model.ServiceModel;
import com.losconfort.confort.service.ServiceService;
import com.losconfort.confortstarterrest.helper.DefaultControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class ServiceControllerImpl extends DefaultControllerImpl<ServiceModel, Long, ServiceService>
    implements ServiceController {
  public ServiceControllerImpl(ServiceService service) {
    super(service);
  }
}
