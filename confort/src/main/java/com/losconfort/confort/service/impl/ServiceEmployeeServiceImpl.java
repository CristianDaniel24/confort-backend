package com.losconfort.confort.service.impl;

import com.losconfort.confort.model.EmployeeModel;
import com.losconfort.confort.model.ServiceEmployeeModel;
import com.losconfort.confort.model.ServiceEmployeePK;
import com.losconfort.confort.model.procedure.ServiceModel;
import com.losconfort.confort.repository.EmployeeRepository;
import com.losconfort.confort.repository.ServiceEmployeeRepository;
import com.losconfort.confort.repository.procedure.ServiceRepository;
import com.losconfort.confort.service.ServiceEmployeeService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceEmployeeServiceImpl
    extends DefaultServiceImpl<ServiceEmployeeModel, ServiceEmployeePK, ServiceEmployeeRepository>
    implements ServiceEmployeeService {

  private final ServiceRepository serviceRepository;
  private final EmployeeRepository employeeRepository;

  public ServiceEmployeeServiceImpl(
      ServiceEmployeeRepository repository,
      ServiceRepository serviceRepository,
      EmployeeRepository employeeRepository) {
    super(repository);
    this.serviceRepository = serviceRepository;
    this.employeeRepository = employeeRepository;
  }

  @Override
  @Transactional
  public ServiceEmployeeModel create(ServiceEmployeeModel model) {
    Long serviceId =
        model.getId() != null && model.getId().getService() != null
            ? model.getId().getService().getId()
            : null;

    Long employeeId =
        model.getId() != null && model.getId().getEmployee() != null
            ? model.getId().getEmployee().getId()
            : null;

    if (serviceId == null || employeeId == null) {
      throw new RuntimeException("ID de servicio o empleado es null");
    }

    ServiceModel service =
        serviceRepository
            .findById(serviceId)
            .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));

    EmployeeModel employee =
        employeeRepository
            .findById(employeeId)
            .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

    ServiceEmployeePK pk = new ServiceEmployeePK();
    pk.setService(service);
    pk.setEmployee(employee);

    model.setId(pk); // Se asigna la clave compuesta

    return repository.save(model); // Se usa directamente el repositorio no el super.create
  }
}
