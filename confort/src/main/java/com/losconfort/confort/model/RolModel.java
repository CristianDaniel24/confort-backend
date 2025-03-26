package com.losconfort.confort.model;

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
@Table(name = "rol")
@EqualsAndHashCode(callSuper = false)
public class RolModel extends DefaultModel<Long> {

  @Serial private static final long serialVersionUID = 7839912432837258386L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", columnDefinition = "VARCHAR(150)", nullable = false)
  private String name;

  @Column(name = "salary", columnDefinition = "DECIMAL(10,2)", nullable = false)
  private Double salary;

  @CreationTimestamp
  @Column(name = "created_at", columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
  private Timestamp createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
  private Timestamp updatedAt;
}
