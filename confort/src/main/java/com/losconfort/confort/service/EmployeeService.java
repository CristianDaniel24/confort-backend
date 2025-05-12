package com.losconfort.confort.service;

import com.losconfort.confort.model.EmployeeModel;
import com.losconfort.confort.model.PersonModel;
import com.losconfort.confortstarterrest.helper.DefaultService;

public interface EmployeeService extends DefaultService<EmployeeModel, Long> {
  boolean existsByPerson(PersonModel personModel);
}
