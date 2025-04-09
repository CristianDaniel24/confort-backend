package com.losconfort.confort.repository;

import com.losconfort.confort.model.ServiceEmployeeModel;
import com.losconfort.confort.model.ServiceEmployeePK;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceEmployeeRepository
    extends DefaultRepository<ServiceEmployeeModel, ServiceEmployeePK> {}
