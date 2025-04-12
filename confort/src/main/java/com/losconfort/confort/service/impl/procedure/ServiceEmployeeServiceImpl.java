package com.losconfort.confort.service.impl.procedure;

import com.losconfort.confort.model.EmployeeModel;
import com.losconfort.confort.model.procedure.ServiceEmployeeModel;
import com.losconfort.confort.model.procedure.ServiceEmployeePK;
import com.losconfort.confort.model.procedure.ServiceModel;
import com.losconfort.confort.repository.ServiceEmployeeRepository;
import com.losconfort.confort.service.EmployeeService;
import com.losconfort.confort.service.procedure.ServiceEmployeeService;
import com.losconfort.confort.service.procedure.ServiceService;
import com.losconfort.confortstarterrest.exception.ResourceNotFoundException;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceEmployeeServiceImpl
    extends DefaultServiceImpl<ServiceEmployeeModel, ServiceEmployeePK, ServiceEmployeeRepository>
    implements ServiceEmployeeService {

  private final ServiceService serviceService;
  private final EmployeeService employeeService;

  public ServiceEmployeeServiceImpl(
      ServiceEmployeeRepository repository,
      ServiceService serviceService,
      EmployeeService employeeService) {
    super(repository);
    this.serviceService = serviceService;
    this.employeeService = employeeService;
  }

  @Override
  @Transactional
  public ServiceEmployeeModel create(ServiceEmployeeModel model) {

    ServiceEmployeePK pk = new ServiceEmployeePK();
    pk.setService(this.getService(model));
    pk.setEmployee(this.getEmployee(model));
    model.setId(pk);

    return repository.save(model);
  }

  private ServiceModel getService(ServiceEmployeeModel model) {
    Long serviceId =
        model.getId() != null && model.getId().getService() != null
            ? model.getId().getService().getId()
            : null;
    if (serviceId == null) {
      throw new ResourceNotFoundException("El id del servicio es null");
    }
    return this.serviceService.read(serviceId);
  }

  private EmployeeModel getEmployee(ServiceEmployeeModel model) {
    Long employeeId =
        model.getId() != null && model.getId().getEmployee() != null
            ? model.getId().getEmployee().getId()
            : null;
    if (employeeId == null) {
      throw new ResourceNotFoundException("El id del empleado es null");
    }
    return this.employeeService.read(employeeId);
  }

  @Override
  public void deleteByServiceId(Long serviceId) {
    this.repository.deleteByIdServiceId(serviceId);
  }
}
