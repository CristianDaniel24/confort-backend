package com.losconfort.confort.repository.procedure;

import com.losconfort.confort.model.procedure.ServiceEmployeeModel;
import com.losconfort.confort.model.procedure.ServiceEmployeePK;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceEmployeeRepository
    extends DefaultRepository<ServiceEmployeeModel, ServiceEmployeePK> {

  // Este metodo borrara todas las relaciones de empleados asociadas a un servicio
  void deleteByIdServiceId(Long serviceId);
}
