package com.losconfort.confort.model.provider;

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
@Table(name = "provider")
@EqualsAndHashCode(callSuper = false)
public class ProviderModel extends DefaultModel<Long> {

  @Serial private static final long serialVersionUID = -3688231142490232564L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", columnDefinition = "VARCHAR(150)", nullable = false)
  private String name;

  @Column(name = "address", columnDefinition = "VARCHAR(150)", nullable = false)
  private String address;

  @Column(name = "phone", columnDefinition = "VARCHAR(10)", nullable = false)
  private String phone;

  @CreationTimestamp
  @Column(name = "created_at", columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
  private Timestamp createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
  private Timestamp updatedAt;
}
