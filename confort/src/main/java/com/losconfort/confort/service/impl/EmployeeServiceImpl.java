package com.losconfort.confort.service.impl;

import com.losconfort.confort.model.EmployeeModel;
import com.losconfort.confort.model.PersonModel;
import com.losconfort.confort.repository.EmployeeRepository;
import com.losconfort.confort.service.EmployeeService;
import com.losconfort.confortstarterrest.exception.UniqueConstraintViolationException;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends DefaultServiceImpl<EmployeeModel, Long, EmployeeRepository>
    implements EmployeeService {
  public EmployeeServiceImpl(EmployeeRepository repository) {
    super(repository);
  }

  @Override
  public EmployeeModel create(EmployeeModel model) {
    String email = model.getPerson().getEmail();

    if (this.repository.existsByPersonEmail(email)) {
      throw new UniqueConstraintViolationException("El correo " + email + " ya esta registrado.");
    }
    return super.create(model);
  }

  @Override
  public boolean existsByPerson(PersonModel personModel) {
    return this.repository.existsByPerson(personModel);
  }
}
