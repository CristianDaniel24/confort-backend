package com.losconfort.confort.repository.payment;

import com.losconfort.confort.model.payment.BillModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends DefaultRepository<BillModel, Long> {
  @Query("SELECT b FROM BillModel b WHERE b.shoppingCart.client.person.id = :personId")
  List<BillModel> findAllByPersonId(@Param("personId") Long personId);
}
