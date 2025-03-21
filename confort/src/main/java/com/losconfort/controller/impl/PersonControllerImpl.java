package com.losconfort.controller.impl;

import com.losconfort.confortstarterrest.helper.DefaultControllerImpl;
import com.losconfort.controller.PersonController;
import com.losconfort.model.Person;
import com.losconfort.service.PersonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonControllerImpl extends DefaultControllerImpl<Person, Long, PersonService>
    implements PersonController {

  public PersonControllerImpl(PersonService service) {
    super(service);
  }
}
