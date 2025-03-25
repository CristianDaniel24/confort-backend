package com.losconfort.confort.service.impl;

import com.losconfort.confort.model.BillModel;
import com.losconfort.confort.repository.BillRepository;
import com.losconfort.confort.service.BillService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl extends DefaultServiceImpl<BillModel, Long, BillRepository>
    implements BillService {
  public BillServiceImpl(BillRepository repository) {
    super(repository);
  }
}
