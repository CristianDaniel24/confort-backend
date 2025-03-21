package com.losconfort.service;

import com.losconfort.confortstarterrest.helper.DefaultService;
import com.losconfort.model.Person;

public interface PersonService extends DefaultService<Person, Long> {

  boolean existsPerson(Long id);
}
