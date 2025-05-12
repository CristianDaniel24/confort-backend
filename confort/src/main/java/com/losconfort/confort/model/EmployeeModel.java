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
@Table(name = "employee")
@EqualsAndHashCode(callSuper = false)
public class EmployeeModel extends DefaultModel<Long> {

  @Serial private static final long serialVersionUID = -6401864923981157790L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @CreationTimestamp
  @Column(name = "created_at", columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
  private Timestamp createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
  private Timestamp updatedAt;

  @OneToOne
  @JoinColumn(name = "person_id", columnDefinition = "BIGINT", nullable = false)
  private PersonModel person;

  @ManyToOne
  @JoinColumn(name = "rol_id", columnDefinition = "BIGINT", nullable = false)
  private RolModel rol;
}
