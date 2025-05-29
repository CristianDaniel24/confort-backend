package com.losconfort.confort.service;

import com.losconfort.confort.model.ClientModel;
import com.losconfort.confort.model.PersonModel;
import com.losconfort.confortstarterrest.helper.DefaultService;

public interface ClientService extends DefaultService<ClientModel, Long> {
  boolean existsByPerson(PersonModel personModel);

  Long totalClients();

  ClientModel newClient();
}
