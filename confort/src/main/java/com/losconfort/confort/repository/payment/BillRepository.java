package com.losconfort.confort.repository.payment;

import com.losconfort.confort.enums.ShoppingCartEnum;
import com.losconfort.confort.model.payment.BillModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends DefaultRepository<BillModel, Long> {
  @Query("SELECT b FROM BillModel b WHERE b.shoppingCart.client.person.id = :personId")
  List<BillModel> findAllByPersonId(@Param("personId") Long personId);

  @Query(
      "SELECT COALESCE(SUM(b.costTotal), 0) "
          + "FROM BillModel b "
          + "WHERE b.shoppingCart.status = :status "
          + "AND b.date >= :startDate")
  Double sumPaidBillsFromLastMonth(
      @Param("status") ShoppingCartEnum status, @Param("startDate") Timestamp startDate);

  BillModel findFirstByShoppingCart_StatusOrderByDateDesc(ShoppingCartEnum status);
}
