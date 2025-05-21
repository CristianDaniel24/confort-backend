package com.losconfort.confort.model.procedure;

import com.losconfort.confort.enums.ServiceEnum;
import com.losconfort.confort.model.car.CarModel;
import com.losconfort.confortstarterrest.helper.DefaultModel;
import jakarta.persistence.*;
import java.io.Serial;
import java.sql.Timestamp;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  private ServiceEnum status;

  @Column(name = "description", columnDefinition = "VARCHAR(250)")
  private String description;

  @Column(name = "due_to", columnDefinition = "TIMESTAMP")
  private Timestamp dueTo;

  @Column(name = "completed_at", columnDefinition = "TIMESTAMP")
  private Timestamp completedAt;

  @ManyToOne
  @JoinColumn(name = "car_id", columnDefinition = "BIGINT")
  private CarModel car;

  @ManyToOne
  @JoinColumn(name = "procedure_id", columnDefinition = "BIGINT")
  private ProcedureModel procedure;

  @CreationTimestamp
  @Column(name = "created_at", columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
  private Timestamp createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
  private Timestamp updatedAt;
}
