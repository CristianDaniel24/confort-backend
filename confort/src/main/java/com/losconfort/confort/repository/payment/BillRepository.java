package com.losconfort.confort.repository.payment;

import com.losconfort.confort.model.payment.BillModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends DefaultRepository<BillModel, Long> {}
