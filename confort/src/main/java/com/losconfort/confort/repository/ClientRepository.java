package com.losconfort.confort.repository;

import com.losconfort.confort.model.ClientModel;
import com.losconfort.confort.model.PersonModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends DefaultRepository<ClientModel, Long> {
  boolean existsByPerson(PersonModel personModel);
}
