package com.losconfort.confort.repository;

import com.losconfort.confort.model.ClientModel;
import com.losconfort.confort.model.PersonModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends DefaultRepository<ClientModel, Long> {
  boolean existsByPerson(PersonModel personModel);

  Optional<ClientModel> findByPersonId(Long personId);

  boolean existsByPersonEmail(String email);

  @Query("SELECT c.person.password FROM ClientModel c WHERE c.id = :clientId")
  String findPasswordByClientId(@Param("clientId") Long clientId);

  long count();

  ClientModel findFirstByOrderByCreatedAtDesc();
}
