package com.losconfort.confort.controller.impl.procedure;

import com.losconfort.confort.controller.procedure.ServiceController;
import com.losconfort.confort.model.procedure.ServiceModel;
import com.losconfort.confort.service.procedure.ServiceService;
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
