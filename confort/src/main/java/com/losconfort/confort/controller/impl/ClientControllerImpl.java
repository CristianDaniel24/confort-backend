package com.losconfort.confort.controller.impl;

import com.losconfort.confort.controller.ClientController;
import com.losconfort.confort.model.ClientModel;
import com.losconfort.confort.service.ClientService;
import com.losconfort.confortstarterrest.helper.DefaultControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientControllerImpl extends DefaultControllerImpl<ClientModel, Long, ClientService>
    implements ClientController {

  public ClientControllerImpl(ClientService service) {
    super(service);
  }
}
