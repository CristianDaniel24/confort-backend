package com.losconfort.model;

import com.losconfort.confortstarterrest.helper.DefaultModel;
import jakarta.persistence.*;
import java.io.Serial;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
@EqualsAndHashCode(callSuper = false)
public class Employee extends DefaultModel<Long> {

  @Serial private static final long serialVersionUID = 4472908799197024110L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "person_creation_id", columnDefinition = "BIGINT", nullable = false)
  private Timestamp personCreationId;

  @Column(name = "person_modification_id", columnDefinition = "BIGINT")
  private Timestamp personModificationId;

  @OneToOne
  @JoinColumn(name = "person_id", columnDefinition = "BIGINT", nullable = false)
  private Person person;

  @ManyToOne
  @JoinColumn(name = "rol_id", columnDefinition = "BIGINT", nullable = false)
  private Rol rol;
}
