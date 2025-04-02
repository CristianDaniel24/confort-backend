package com.losconfort.confort.repository.payment;

import com.losconfort.confort.model.payment.PaymentModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends DefaultRepository<PaymentModel, Long> {}
