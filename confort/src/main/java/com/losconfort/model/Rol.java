package com.losconfort.model;

import com.losconfort.confortstarterrest.helper.DefaultModel;
import jakarta.persistence.*;
import java.io.Serial;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rol")
@EqualsAndHashCode(callSuper = false)
public class Rol extends DefaultModel<Long> {

  @Serial private static final long serialVersionUID = -8288035575893487531L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", columnDefinition = "VARCHAR(150)", nullable = false)
  private String name;

  @Column(name = "salary", columnDefinition = "DECIMAL(10,2)", nullable = false)
  private Double salary;

  @Column(name = "person_creation_id", columnDefinition = "BIGINT", nullable = false)
  private LocalDateTime personCreationId;

  @Column(name = "person_modification_id", columnDefinition = "BIGINT")
  private LocalDateTime personModificationId;
}
