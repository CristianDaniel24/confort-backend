package com.losconfort.confort.repository.procedure;

import com.losconfort.confort.model.procedure.ServiceModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends DefaultRepository<ServiceModel, Long> {}
