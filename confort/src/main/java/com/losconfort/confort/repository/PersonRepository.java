package com.losconfort.confort.repository;

import com.losconfort.confort.model.PersonModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends DefaultRepository<PersonModel, Long> {
  // Aqui se hace la query para buscar el person por correo y contraseña
  Optional<PersonModel> findByEmailAndPassword(String email, String password);
}
