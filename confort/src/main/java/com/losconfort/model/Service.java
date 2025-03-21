package com.losconfort.model;

import com.losconfort.confortstarterrest.helper.DefaultModel;
import com.losconfort.enums.ServiceEnum;
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
@Table(name = "service")
@EqualsAndHashCode(callSuper = false)
public class Service extends DefaultModel<Long> {

  @Serial private static final long serialVersionUID = -9147570711258840753L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", columnDefinition = "VARCHAR(150)", nullable = false)
  private String name;

  @Column(name = "price", columnDefinition = "DECIMAL(10,2)", nullable = false)
  private Double price;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", columnDefinition = "STRING", nullable = false)
  private ServiceEnum status;

  @Column(name = "description", columnDefinition = "VARCHAR(250)", nullable = false)
  private String description;

  @Column(name = "due_to", columnDefinition = "TIMESTAMP", nullable = false)
  private LocalDateTime dueTo;

  @Column(name = "completed_at", columnDefinition = "TIMESTAMP", nullable = false)
  private LocalDateTime completedAt;

  @Column(
      name = "person_creation_id",
      columnDefinition = "BIGINT",
      nullable = false,
      updatable = false)
  private Long personCreationId;

  @Column(name = "person_modification_id", columnDefinition = "BIGINT")
  private Long personModificationId;

  @ManyToOne
  @JoinColumn(name = "car_id", columnDefinition = "BIGINT", nullable = false)
  private Car car;
}
