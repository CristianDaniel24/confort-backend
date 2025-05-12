package com.losconfort.confort.service.impl;

import com.losconfort.confort.model.PersonModel;
import com.losconfort.confort.repository.PersonRepository;
import com.losconfort.confort.service.PersonService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends DefaultServiceImpl<PersonModel, Long, PersonRepository>
    implements PersonService {
  public PersonServiceImpl(PersonRepository repository) {
    super(repository);
  }
}
