package com.losconfort.confort.controller.payment;

import com.losconfort.confort.model.payment.BillModel;
import com.losconfort.confort.model.payment.PaymentModel;
import com.losconfort.confortstarterrest.helper.DefaultController;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface BillController extends DefaultController<BillModel, Long> {

  ResponseEntity<List<BillModel>> getBillByPersonId(Long personId);

  ResponseEntity<BillModel> confirmOrder(Long orderId, PaymentModel methodPayment);

  ResponseEntity<BillModel> cancelOrder(Long billId);
}
