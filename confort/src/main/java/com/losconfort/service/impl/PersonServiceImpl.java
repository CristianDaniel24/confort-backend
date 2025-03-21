package com.losconfort.service.impl;

import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import com.losconfort.model.Person;
import com.losconfort.repository.PersonRepository;
import com.losconfort.service.PersonService;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends DefaultServiceImpl<Person, Long, PersonRepository>
    implements PersonService {

  public PersonServiceImpl(PersonRepository repository) {
    super(repository);
  }

  @Override
  public Person create(Person model) {
    model.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
    return super.create(model);
  }

  @Override
  public Person update(Long id, Person model) {
    model.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
    return super.update(id, model);
  }

  @Override
  public boolean existsPerson(Long id) {
    return this.repository.existsById(id);
  }
}
