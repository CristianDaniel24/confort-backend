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
@Table(name = "type_car")
@EqualsAndHashCode(callSuper = false)
public class TypeCar extends DefaultModel<Long> {

  @Serial private static final long serialVersionUID = 2047044463820561157L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "model", columnDefinition = "VARCHAR(150)", nullable = false)
  private String model;

  @Column(name = "year", columnDefinition = "TIMESTAMP", nullable = false)
  private LocalDateTime year;

  @Column(
      name = "person_creation_id",
      columnDefinition = "BIGINT",
      nullable = false,
      updatable = false)
  private Long personCreationId;

  @Column(name = "person_modification_id", columnDefinition = "BIGINT")
  private Long personModificationId;
}
