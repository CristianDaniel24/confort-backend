package com.losconfort.confort.service.impl;

import com.losconfort.confort.model.ClientModel;
import com.losconfort.confort.model.PersonModel;
import com.losconfort.confort.repository.ClientRepository;
import com.losconfort.confort.service.ClientService;
import com.losconfort.confort.service.PersonService;
import com.losconfort.confortstarterrest.exception.UniqueConstraintViolationException;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends DefaultServiceImpl<ClientModel, Long, ClientRepository>
    implements ClientService {
  private final PersonService personService;

  public ClientServiceImpl(ClientRepository repository, @Lazy PersonService personService) {
    super(repository);
    this.personService = personService;
  }

  @Override
  public ClientModel create(ClientModel model) {
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
  public ClientModel update(Long id, ClientModel model) {
    model.setPerson(this.personService.update(id, model.getPerson()));
    return model;
  }
}
