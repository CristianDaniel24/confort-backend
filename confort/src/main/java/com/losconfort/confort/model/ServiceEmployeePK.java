package com.losconfort.confort.model;

import com.losconfort.confort.model.procedure.ServiceModel;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ServiceEmployeePK implements Serializable {

  @Serial private static final long serialVersionUID = 6418708583249218417L;

  @ManyToOne
  @JoinColumn(name = "service_id", columnDefinition = "BIGINT", nullable = false)
  private ServiceModel service;

  @ManyToOne
  @JoinColumn(name = "employee_id", columnDefinition = "BIGINT", nullable = false)
  private EmployeeModel employee;
}
