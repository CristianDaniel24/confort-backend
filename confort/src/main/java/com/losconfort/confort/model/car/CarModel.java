package com.losconfort.confort.model.car;

import com.losconfort.confort.model.ClientModel;
import com.losconfort.confortstarterrest.helper.DefaultModel;
import jakarta.persistence.*;
import java.io.Serial;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car")
@EqualsAndHashCode(callSuper = false)
public class CarModel extends DefaultModel<Long> {

  @Serial private static final long serialVersionUID = 7871354446062969171L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "color", columnDefinition = "VARCHAR(150)", nullable = false)
  private String color;

  @Column(name = "plate", columnDefinition = "VARCHAR(150)", nullable = false)
  private String plate;

  @OneToOne
  @JoinColumn(name = "type_car", columnDefinition = "BIGINT", nullable = false)
  private TypeCarModel typeCar;

  @ManyToOne
  @JoinColumn(name = "client_id", columnDefinition = "BIGINT", nullable = false)
  private ClientModel client;

  @CreationTimestamp
  @Column(name = "created_at", columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
  private Timestamp createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
  private Timestamp updatedAt;
}
