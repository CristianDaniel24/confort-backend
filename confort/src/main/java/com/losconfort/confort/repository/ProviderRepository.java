package com.losconfort.confort.repository;

import com.losconfort.confort.model.ProviderModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends DefaultRepository<ProviderModel, Long> {}
