package com.losconfort.confort.service.impl;

import com.losconfort.confort.model.PaymentModel;
import com.losconfort.confort.repository.PaymentRepository;
import com.losconfort.confort.service.PaymentService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl extends DefaultServiceImpl<PaymentModel, Long, PaymentRepository>
    implements PaymentService {
  public PaymentServiceImpl(PaymentRepository repository) {
    super(repository);
  }
}
