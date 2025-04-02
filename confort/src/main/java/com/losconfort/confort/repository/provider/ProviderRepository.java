package com.losconfort.confort.repository.provider;

import com.losconfort.confort.model.provider.ProviderModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends DefaultRepository<ProviderModel, Long> {}
