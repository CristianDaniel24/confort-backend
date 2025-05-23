package com.losconfort.confort.controller.impl;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.losconfort.confort.controller.EmployeeController;
import com.losconfort.confort.model.EmployeeModel;
import com.losconfort.confort.service.EmployeeService;
import com.losconfort.confortstarterrest.helper.DefaultControllerImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeControllerImpl
    extends DefaultControllerImpl<EmployeeModel, Long, EmployeeService>
    implements EmployeeController {
  public EmployeeControllerImpl(EmployeeService service) {
    super(service);
  }

  @Override
  @GetMapping(path = "/person/{id}", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<EmployeeModel> findByPersonId(@PathVariable("id") Long personId) {
    return ResponseEntity.ok(this.service.findByPersonId(personId));
  }
}
