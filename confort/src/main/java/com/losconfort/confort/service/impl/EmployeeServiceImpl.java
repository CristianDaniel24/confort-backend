package com.losconfort.confort.service.impl;

import com.losconfort.confort.model.EmployeeModel;
import com.losconfort.confort.model.PersonModel;
import com.losconfort.confort.repository.EmployeeRepository;
import com.losconfort.confort.service.EmployeeService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends DefaultServiceImpl<EmployeeModel, Long, EmployeeRepository>
    implements EmployeeService {
  public EmployeeServiceImpl(EmployeeRepository repository) {
    super(repository);
  }

  // Se sobreescribe el metodo de crear para validar que el correo no exista ya en la base de datos,
  // si ya existe se retorna un error lindo para el frontend
  @Override
  public boolean existsByPerson(PersonModel personModel) {
    return this.repository.existsByPerson(personModel);
  }
}
