package com.losconfort.confort.repository;

import com.losconfort.confort.model.PersonModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends DefaultRepository<PersonModel, Long> {

  Optional<PersonModel> findByEmail(String email);
}
