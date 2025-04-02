package com.losconfort.confort.controller.impl;

import com.losconfort.confort.controller.EmployeeController;
import com.losconfort.confort.model.EmployeeModel;
import com.losconfort.confort.service.EmployeeService;
import com.losconfort.confortstarterrest.helper.DefaultControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeControllerImpl
    extends DefaultControllerImpl<EmployeeModel, Long, EmployeeService>
    implements EmployeeController {
  public EmployeeControllerImpl(EmployeeService service) {
    super(service);
  }
}
