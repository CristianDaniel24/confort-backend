package com.losconfort.confort.service.impl;

import com.losconfort.confort.dto.ChangePasswordDTO;
import com.losconfort.confort.dto.LoginRequestDTO;
import com.losconfort.confort.dto.LoginResponseDTO;
import com.losconfort.confort.dto.UserEmailDTO;
import com.losconfort.confort.enums.RecoveryPasswordEnum;
import com.losconfort.confort.model.PersonModel;
import com.losconfort.confort.model.RecoveryPasswordModel;
import com.losconfort.confort.repository.PersonRepository;
import com.losconfort.confort.service.ClientService;
import com.losconfort.confort.service.EmployeeService;
import com.losconfort.confort.service.PersonService;
import com.losconfort.confort.service.RecoveryPasswordService;
import com.losconfort.confortstarterrest.exception.ResourceNotFoundException;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

@Service
public class PersonServiceImpl extends DefaultServiceImpl<PersonModel, Long, PersonRepository>
    implements PersonService {

  private final EmployeeService employeeService;
  private final ClientService clientService;
  private final RecoveryPasswordService recoveryPasswordService;
  private final PasswordEncoder passwordEncoder;

  public PersonServiceImpl(
      PersonRepository repository,
      EmployeeService employeeService,
      ClientService clientService,
      RecoveryPasswordService recoveryPasswordService,
      PasswordEncoder passwordEncoder) {
    super(repository);
    this.employeeService = employeeService;
    this.clientService = clientService;
    this.recoveryPasswordService = recoveryPasswordService;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public LoginResponseDTO signin(LoginRequestDTO loginRequest) {
    PersonModel personModel =
        this.repository
            .findByEmail(loginRequest.getEmail())
            .orElseThrow(
                () -> new ResourceNotFoundException("Correo invalido o contraseña invalida"));

    // Comparar la contraseña usando BCrypt
    if (!passwordEncoder.matches(loginRequest.getPassword(), personModel.getPassword())) {
      throw new ResourceNotFoundException("Correo invalido o contraseña invalida");
    }

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

  @Override
  public UserEmailDTO recoverPassword(UserEmailDTO model) {
    PersonModel person =
        this.repository
            .findByEmail(model.getEmail())
            .orElseThrow(
                () ->
                    new ResourceNotFoundException(
                        "No se encontro una cuenta asociada a ese correo!"));

    String code = UUID.randomUUID().toString();

    RecoveryPasswordModel recoveryPassword = new RecoveryPasswordModel();
    recoveryPassword.setCode(code);
    recoveryPassword.setStatus(RecoveryPasswordEnum.CREATED);
    recoveryPassword.setPerson(person);
    this.recoveryPasswordService.create(recoveryPassword);

    Context context = new Context();
    context.setVariable("name", person.getFirstName());
    context.setVariable("message", "Este es tu código de recuperación:");
    context.setVariable("code", code);

    this.recoveryPasswordService.sendRecoveryPassword(
        person, "Recuperación de Contraseña", context, "email-template");

    return null;
  }

  @Override
  public ChangePasswordDTO changePassword(ChangePasswordDTO model) {
    RecoveryPasswordModel recovery = this.recoveryPasswordService.findByCode(model.getCode());

    LocalDateTime now = LocalDateTime.now();
    LocalDateTime createdAt = recovery.getCreatedAt().toLocalDateTime();
    Duration diferencia = Duration.between(createdAt, now);

    if (recovery.getStatus() != RecoveryPasswordEnum.CREATED || diferencia.toMinutes() > 10) {
      recovery.setStatus(RecoveryPasswordEnum.EXPIRED);
      this.recoveryPasswordService.saveNewStatus(recovery);
      throw new ResourceNotFoundException("El enlace ha expirado.");
    }

    PersonModel person = recovery.getPerson();
    String hashedPassword = passwordEncoder.encode(model.getPassword());
    person.setPassword(hashedPassword);
    this.repository.save(person);

    recovery.setStatus(RecoveryPasswordEnum.USED);
    this.recoveryPasswordService.saveNewStatus(recovery);
    return null;
  }
}
