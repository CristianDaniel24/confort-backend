package com.losconfort.confort.controller.payment;

import com.losconfort.confort.model.payment.BillModel;
import com.losconfort.confortstarterrest.helper.DefaultController;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface BillController extends DefaultController<BillModel, Long> {

  ResponseEntity<List<BillModel>> getBillByPersonId(@PathVariable("personId") Long personId);

  ResponseEntity<BillModel> confirmOrder(@PathVariable("personId") Long orderId);

  ResponseEntity<BillModel> cancelOrder(@PathVariable("personId") Long orderId);
}
