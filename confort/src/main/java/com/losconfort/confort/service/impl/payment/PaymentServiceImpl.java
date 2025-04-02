package com.losconfort.confort.service.impl.payment;

import com.losconfort.confort.model.payment.PaymentModel;
import com.losconfort.confort.repository.payment.PaymentRepository;
import com.losconfort.confort.service.payment.PaymentService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl extends DefaultServiceImpl<PaymentModel, Long, PaymentRepository>
    implements PaymentService {
  public PaymentServiceImpl(PaymentRepository repository) {
    super(repository);
  }
}
