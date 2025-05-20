package com.losconfort.confort.repository.car;

import com.losconfort.confort.model.car.CarModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends DefaultRepository<CarModel, Long> {
  @Query("SELECT c FROM CarModel c WHERE c.client.person.id = :personId")
  List<CarModel> findAllByPersonId(@Param("personId") Long personId);
}
