package com.losconfort.confort.controller.impl.procedure;

import com.losconfort.confort.controller.procedure.ServiceEmployeeController;
import com.losconfort.confort.model.procedure.ServiceEmployeeModel;
import com.losconfort.confort.model.procedure.ServiceEmployeePK;
import com.losconfort.confort.service.procedure.ServiceEmployeeService;
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
