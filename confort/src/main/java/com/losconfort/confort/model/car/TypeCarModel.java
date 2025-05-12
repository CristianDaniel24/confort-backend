package com.losconfort.confort.model.car;

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
@Table(name = "type_car")
@EqualsAndHashCode(callSuper = false)
public class TypeCarModel extends DefaultModel<Long> {

  @Serial private static final long serialVersionUID = 2047044463820561157L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "model", columnDefinition = "VARCHAR(150)", nullable = false)
  private String model;

  @Column(name = "year", columnDefinition = "SMALLINT", nullable = false)
  private Integer year;

  @CreationTimestamp
  @Column(name = "created_at", columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
  private Timestamp createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
  private Timestamp updatedAt;
}
