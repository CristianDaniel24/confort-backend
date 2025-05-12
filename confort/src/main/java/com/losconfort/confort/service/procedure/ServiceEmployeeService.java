package com.losconfort.confort.service.procedure;

import com.losconfort.confort.model.procedure.ServiceEmployeeModel;
import com.losconfort.confort.model.procedure.ServiceEmployeePK;
import com.losconfort.confortstarterrest.helper.DefaultService;

public interface ServiceEmployeeService
    extends DefaultService<ServiceEmployeeModel, ServiceEmployeePK> {

  void deleteByServiceId(Long serviceId);
}
