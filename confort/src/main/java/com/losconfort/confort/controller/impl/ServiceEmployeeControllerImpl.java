package com.losconfort.confort.controller.impl;

import com.losconfort.confort.controller.ServiceEmployeeController;
import com.losconfort.confort.model.ServiceEmployeeModel;
import com.losconfort.confort.model.ServiceEmployeePK;
import com.losconfort.confort.service.ServiceEmployeeService;
import com.losconfort.confortstarterrest.helper.DefaultControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service-employee")
public class ServiceEmployeeControllerImpl
    extends DefaultControllerImpl<ServiceEmployeeModel, ServiceEmployeePK, ServiceEmployeeService>
    implements ServiceEmployeeController {
  public ServiceEmployeeControllerImpl(ServiceEmployeeService service) {
    super(service);
  }
}
