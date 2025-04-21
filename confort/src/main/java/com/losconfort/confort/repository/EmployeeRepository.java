package com.losconfort.confort.repository;

import com.losconfort.confort.model.EmployeeModel;
import com.losconfort.confort.model.PersonModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends DefaultRepository<EmployeeModel, Long> {
  boolean existsByPerson(PersonModel personModel);
}
