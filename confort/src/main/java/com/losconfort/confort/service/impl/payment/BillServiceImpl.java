package com.losconfort.confort.service.impl.payment;

import com.losconfort.confort.enums.ShoppingCartEnum;
import com.losconfort.confort.model.payment.BillModel;
import com.losconfort.confort.model.payment.PaymentModel;
import com.losconfort.confort.repository.payment.BillRepository;
import com.losconfort.confort.service.payment.BillService;
import com.losconfort.confort.service.payment.PaymentService;
import com.losconfort.confortstarterrest.exception.ResourceNotFoundException;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl extends DefaultServiceImpl<BillModel, Long, BillRepository>
    implements BillService {

  private final PaymentService paymentService;

  public BillServiceImpl(BillRepository repository, PaymentService paymentService) {
    super(repository);
    this.paymentService = paymentService;
  }

  @Override
  public List<BillModel> getBillByPersonId(Long personId) {
    return this.repository.findAllByPersonId(personId);
  }

  @Override
  public BillModel confirmOrder(Long billId, PaymentModel payment) {
    BillModel bill =
        this.repository
            .findById(billId)
            .orElseThrow(
                () ->
                    new ResourceNotFoundException(
                        "Ocurrio un error al intentar encontrar el pedido"));

    bill.getShoppingCart().setStatus(ShoppingCartEnum.PAGADO);
    payment.setBill(bill);
    this.paymentService.create(payment);
    return this.repository.save(bill);
  }

  @Override
  public BillModel cancelOrder(Long billId) {
    BillModel bill =
        this.repository
            .findById(billId)
            .orElseThrow(
                () ->
                    new ResourceNotFoundException(
                        "Ocurrio un error al intentar encontrar el pedido"));

    bill.getShoppingCart().setStatus(ShoppingCartEnum.CANCELADO);
    return this.repository.save(bill);
  }

  @Override
  public Double totalSumMonth() {
    LocalDate firstDayOfLastMonth = LocalDate.now().minusMonths(1).withDayOfMonth(1);
    Timestamp startDate = Timestamp.valueOf(firstDayOfLastMonth.atStartOfDay());
    return this.repository.sumPaidBillsFromLastMonth(ShoppingCartEnum.PAGADO, startDate);
  }

  @Override
  public BillModel billPaid() {
    return this.repository.findFirstByShoppingCart_StatusOrderByDateDesc(ShoppingCartEnum.PAGADO);
  }
}
