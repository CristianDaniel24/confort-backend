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
@Table(name = "car")
@EqualsAndHashCode(callSuper = false)
public class Car extends DefaultModel<Long> {

  @Serial private static final long serialVersionUID = 7871354446062969171L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "color", columnDefinition = "VARCHAR(150)", nullable = false)
  private String color;

  @Column(name = "plate", columnDefinition = "VARCHAR(150)", nullable = false)
  private String plate;

  @Column(name = "person_creation_id", columnDefinition = "BIGINT", nullable = false)
  private LocalDateTime personCreationId;

  @Column(name = "person_modification_id", columnDefinition = "BIGINT")
  private LocalDateTime personModificationId;

  @OneToOne
  @JoinColumn(name = "type_car", columnDefinition = "BIGINT", nullable = false)
  private TypeCar typeCar;

  @ManyToOne
  @JoinColumn(name = "client_id", columnDefinition = "BIGINT", nullable = false)
  private Client client;
}
