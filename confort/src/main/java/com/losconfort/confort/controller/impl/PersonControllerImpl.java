package com.losconfort.confort.controller.impl;

import com.losconfort.confort.controller.PersonController;
import com.losconfort.confort.model.PersonModel;
import com.losconfort.confort.service.PersonService;
import com.losconfort.confortstarterrest.helper.DefaultControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class PersonControllerImpl extends DefaultControllerImpl<PersonModel, Long, PersonService> implements PersonController {
    public PersonControllerImpl(PersonService service) {
        super(service);
    }
}
