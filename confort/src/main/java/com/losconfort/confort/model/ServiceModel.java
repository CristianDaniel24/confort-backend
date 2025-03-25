package com.losconfort.confort.model;

import com.losconfort.confort.enums.ServiceEnum;
import com.losconfort.confortstarterrest.helper.DefaultModel;
import jakarta.persistence.*;
import java.io.Serial;
import java.sql.Timestamp;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "service")
@EqualsAndHashCode(callSuper = false)
public class ServiceModel extends DefaultModel<Long> {

  @Serial private static final long serialVersionUID = -5748578294917829225L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", columnDefinition = "VARCHAR(150)", nullable = false)
  private String name;

  @Column(name = "price", columnDefinition = "DECIMAL(10,2)", nullable = false)
  private Double price;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  private ServiceEnum status;

  @Column(name = "description", columnDefinition = "VARCHAR(250)", nullable = false)
  private String description;

  @Column(name = "due_to", columnDefinition = "TIMESTAMP", nullable = false)
  private Timestamp dueTo;

  @Column(name = "completed_at", columnDefinition = "TIMESTAMP", nullable = false)
  private Timestamp completedAt;

  @ManyToOne
  @JoinColumn(name = "car_id", columnDefinition = "BIGINT", nullable = false)
  private CarModel carModel;
}
