package com.losconfort.confort.controller;

import com.losconfort.confort.model.EmployeeModel;
import com.losconfort.confortstarterrest.helper.DefaultController;
import org.springframework.http.ResponseEntity;

public interface EmployeeController extends DefaultController<EmployeeModel, Long> {
  ResponseEntity<EmployeeModel> findByPersonId(Long personId);
}
