package com.losconfort.confort.service.impl;

import com.losconfort.confort.model.ClientModel;
import com.losconfort.confort.model.PersonModel;
import com.losconfort.confort.repository.ClientRepository;
import com.losconfort.confort.service.ClientService;
import com.losconfort.confort.service.PersonService;
import com.losconfort.confortstarterrest.exception.UniqueConstraintViolationException;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends DefaultServiceImpl<ClientModel, Long, ClientRepository>
    implements ClientService {

  private final PersonService personService;
  private final PasswordEncoder passwordEncoder;

  public ClientServiceImpl(
      ClientRepository repository,
      @Lazy PersonService personService,
      PasswordEncoder passwordEncoder) {
    super(repository);
    this.personService = personService;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public ClientModel create(ClientModel model) {
    String email = model.getPerson().getEmail();

    if (this.repository.existsByPersonEmail(email)) {
      throw new UniqueConstraintViolationException("El correo " + email + " ya esta registrado.");
    }
    String hashedPassword = passwordEncoder.encode(model.getPerson().getPassword());
    model.getPerson().setPassword(hashedPassword);
    return super.create(model);
  }

  @Override
  public boolean existsByPerson(PersonModel personModel) {
    return this.repository.existsByPerson(personModel);
  }

  @Override
  public ClientModel update(Long id, ClientModel model) {
    String currentPassword = this.repository.findPasswordByClientId(id);

    model.getPerson().setPassword(currentPassword);
    model.setPerson(this.personService.update(id, model.getPerson()));
    return model;
  }

  @Override
  public Long totalClients() {
    return this.repository.count();
  }

  @Override
  public ClientModel newClient() {
    return this.repository.findFirstByOrderByCreatedAtDesc();
  }
}
