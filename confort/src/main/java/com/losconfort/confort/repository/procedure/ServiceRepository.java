package com.losconfort.confort.repository.procedure;

import com.losconfort.confort.enums.ServiceEnum;
import com.losconfort.confort.model.PersonModel;
import com.losconfort.confort.model.procedure.ServiceModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends DefaultRepository<ServiceModel, Long> {
  @Query(
      "SELECT p FROM ServiceModel s "
          + "JOIN s.car c "
          + "JOIN c.client cl "
          + "JOIN cl.person p "
          + "WHERE s.id = :serviceId")
  PersonModel findPersonByServiceId(@Param("serviceId") Long serviceId);

  @Query("SELECT COUNT(s) FROM ServiceModel s WHERE s.status = :status")
  Long countCreatedServices(@Param("status") ServiceEnum status);

  @Query("SELECT s FROM ServiceModel s WHERE s.status = :status ORDER BY s.createdAt DESC")
  ServiceModel findTopByStatusOrderByCreatedAtDesc(@Param("status") ServiceEnum status);
}
