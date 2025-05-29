package com.losconfort.confort.repository;

import com.losconfort.confort.model.EmployeeModel;
import com.losconfort.confort.model.PersonModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends DefaultRepository<EmployeeModel, Long> {
  boolean existsByPerson(PersonModel personModel);

  boolean existsByPersonEmail(String email);

  @Query("SELECT e FROM EmployeeModel e WHERE e.person.id = :personId")
  Optional<EmployeeModel> findByPersonId(@Param("personId") Long personId);

  @Query("SELECT e.person.password FROM EmployeeModel e WHERE e.person.id = :personId")
  Optional<String> findPasswordByPersonId(@Param("personId") Long personId);
}
