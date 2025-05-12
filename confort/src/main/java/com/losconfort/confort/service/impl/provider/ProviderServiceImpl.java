package com.losconfort.confort.service.impl.provider;

import com.losconfort.confort.model.provider.ProviderModel;
import com.losconfort.confort.repository.provider.ProviderRepository;
import com.losconfort.confort.service.provider.ProviderService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl extends DefaultServiceImpl<ProviderModel, Long, ProviderRepository>
    implements ProviderService {
  public ProviderServiceImpl(ProviderRepository repository) {
    super(repository);
  }
}
