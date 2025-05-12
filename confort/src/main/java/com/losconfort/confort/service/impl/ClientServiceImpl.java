package com.losconfort.confort.service.impl;

import com.losconfort.confort.model.ClientModel;
import com.losconfort.confort.repository.ClientRepository;
import com.losconfort.confort.service.ClientService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends DefaultServiceImpl<ClientModel, Long, ClientRepository>
    implements ClientService {
  public ClientServiceImpl(ClientRepository repository) {
    super(repository);
  }
}
