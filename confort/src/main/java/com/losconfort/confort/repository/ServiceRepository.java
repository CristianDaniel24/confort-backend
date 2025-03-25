package com.losconfort.confort.repository;

import com.losconfort.confort.model.ServiceModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends DefaultRepository<ServiceModel, Long> {}
