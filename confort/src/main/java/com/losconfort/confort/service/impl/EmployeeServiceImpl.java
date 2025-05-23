package com.losconfort.confort.service.impl;

import com.losconfort.confort.model.EmployeeModel;
import com.losconfort.confort.model.PersonModel;
import com.losconfort.confort.repository.EmployeeRepository;
import com.losconfort.confort.service.EmployeeService;
import com.losconfort.confort.service.PersonService;
import com.losconfort.confortstarterrest.exception.ResourceNotFoundException;
import com.losconfort.confortstarterrest.exception.UniqueConstraintViolationException;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends DefaultServiceImpl<EmployeeModel, Long, EmployeeRepository>
    implements EmployeeService {
  private final PersonService personService;

  public EmployeeServiceImpl(EmployeeRepository repository, @Lazy PersonService personService) {
    super(repository);
    this.personService = personService;
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

  @Override
  public EmployeeModel findByPersonId(Long personId) {
    return this.repository
        .findByPersonId(personId)
        .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado!!"));
  }

  @Override
  public EmployeeModel update(Long id, EmployeeModel model) {
    model.setPerson(this.personService.update(id, model.getPerson()));
    return model;
  }
}
