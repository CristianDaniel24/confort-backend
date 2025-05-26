package com.losconfort.confort.model;

import com.losconfort.confort.enums.RecoveryPasswordEnum;
import com.losconfort.confortstarterrest.helper.DefaultModel;
import jakarta.persistence.*;
import java.io.Serial;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "password_recovery")
@EqualsAndHashCode(callSuper = false)
public class RecoveryPasswordModel extends DefaultModel<Long> {

  @Serial private static final long serialVersionUID = 3921321300405122080L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "code", columnDefinition = "VARCHAR(45)", nullable = false)
  private String code;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  private RecoveryPasswordEnum status;

  @ManyToOne
  @JoinColumn(name = "person_id", columnDefinition = "BIGINT", nullable = false)
  private PersonModel person;

  @CreationTimestamp
  @Column(name = "created_at", columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
  private Timestamp createdAt;
}
