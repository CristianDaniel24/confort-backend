package com.losconfort.confort.service.impl.payment;

import com.losconfort.confort.model.payment.BillModel;
import com.losconfort.confort.repository.payment.BillRepository;
import com.losconfort.confort.service.payment.BillService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl extends DefaultServiceImpl<BillModel, Long, BillRepository>
    implements BillService {
  public BillServiceImpl(BillRepository repository) {
    super(repository);
  }
}
