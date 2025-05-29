package com.losconfort.confort.service.payment;

import com.losconfort.confort.model.payment.BillModel;
import com.losconfort.confort.model.payment.PaymentModel;
import com.losconfort.confortstarterrest.helper.DefaultService;
import java.util.List;

public interface BillService extends DefaultService<BillModel, Long> {
  List<BillModel> getBillByPersonId(Long personId);

  BillModel confirmOrder(Long billId, PaymentModel payment);

  BillModel cancelOrder(Long billId);

  Double totalSumMonth();

  BillModel billPaid();
}
