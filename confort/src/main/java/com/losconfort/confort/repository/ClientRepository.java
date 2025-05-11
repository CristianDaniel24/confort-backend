package com.losconfort.confort.repository;

import com.losconfort.confort.model.ClientModel;
import com.losconfort.confort.model.PersonModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends DefaultRepository<ClientModel, Long> {
  boolean existsByPerson(PersonModel personModel);

  Optional<ClientModel> findByPersonId(Long personId);

  boolean existsByPersonEmail(String email);
}
