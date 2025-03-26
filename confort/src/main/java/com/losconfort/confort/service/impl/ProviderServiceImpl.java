package com.losconfort.confort.service.impl;

import com.losconfort.confort.model.ProviderModel;
import com.losconfort.confort.repository.ProviderRepository;
import com.losconfort.confort.service.ProviderService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl extends DefaultServiceImpl<ProviderModel, Long, ProviderRepository>
    implements ProviderService {
  public ProviderServiceImpl(ProviderRepository repository) {
    super(repository);
  }
}
