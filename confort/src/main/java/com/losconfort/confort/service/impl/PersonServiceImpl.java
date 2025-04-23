package com.losconfort.confort.service.impl;

import com.losconfort.confort.dto.LoginRequestDTO;
import com.losconfort.confort.dto.LoginResponseDTO;
import com.losconfort.confort.model.PersonModel;
import com.losconfort.confort.repository.PersonRepository;
import com.losconfort.confort.service.ClientService;
import com.losconfort.confort.service.EmployeeService;
import com.losconfort.confort.service.PersonService;
import com.losconfort.confortstarterrest.exception.ResourceNotFoundException;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends DefaultServiceImpl<PersonModel, Long, PersonRepository>
    implements PersonService {

  private final EmployeeService employeeService;
  private final ClientService clientService;

  public PersonServiceImpl(
      PersonRepository repository, EmployeeService employeeService, ClientService clientService) {
    super(repository);
    this.employeeService = employeeService;
    this.clientService = clientService;
  }

  @Override
  public LoginResponseDTO signin(LoginRequestDTO loginRequest) {
    PersonModel personModel =
        this.repository
            .findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword())
            .orElseThrow(
                () -> new ResourceNotFoundException("Correo invalido o contraseña invalida"));

    boolean isEmployee = this.employeeService.existsByPerson(personModel);
    boolean isClient = this.clientService.existsByPerson(personModel);

    personModel.setPassword(null);

    LoginResponseDTO response = new LoginResponseDTO();
    response.setPerson(personModel);

    if (isEmployee) {
      response.setRol("employee");
    } else if (isClient) {
      response.setRol("client");
    } else {
      throw new ResourceNotFoundException(
          "La persona no esta asociada a un empleado ni a un cliente");
    }
    return response;
  }
}
