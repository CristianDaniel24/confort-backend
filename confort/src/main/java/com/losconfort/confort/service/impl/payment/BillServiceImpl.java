package com.losconfort.confort.service.impl.payment;

import com.losconfort.confort.model.payment.BillModel;
import com.losconfort.confort.repository.payment.BillRepository;
import com.losconfort.confort.service.payment.BillService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl extends DefaultServiceImpl<BillModel, Long, BillRepository>
    implements BillService {
  public BillServiceImpl(BillRepository repository) {
    super(repository);
  }

  @Override
  public List<BillModel> getBillByPersonId(Long personId) {
    return this.repository.findAllByPersonId(personId);
  }
}
