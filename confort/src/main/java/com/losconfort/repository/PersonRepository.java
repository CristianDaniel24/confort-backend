package com.losconfort.repository;

import com.losconfort.confortstarterrest.helper.DefaultRepository;
import com.losconfort.model.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends DefaultRepository<Person, Long> {}
