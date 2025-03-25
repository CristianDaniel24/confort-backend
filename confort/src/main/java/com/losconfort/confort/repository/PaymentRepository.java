package com.losconfort.confort.repository;

import com.losconfort.confort.model.PaymentModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends DefaultRepository<PaymentModel, Long> {}
