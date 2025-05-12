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
@Table(name = "product")
@EqualsAndHashCode(callSuper = false)
public class ProductModel extends DefaultModel<Long> {

  @Serial private static final long serialVersionUID = 3590564597301572042L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", columnDefinition = "VARCHAR(150)", nullable = false)
  private String name;

  @Column(name = "cost", columnDefinition = "DECIMAL(10,2)", nullable = false)
  private Double cost;

  @Column(name = "code", columnDefinition = "VARCHAR(250)", nullable = false)
  private String code;

  @Column(name = "stock", columnDefinition = "BIGINT", nullable = false)
  private Long stock;

  @CreationTimestamp
  @Column(name = "created_at", columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
  private Timestamp createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
  private Timestamp updatedAt;

  @OneToOne
  @JoinColumn(name = "type_product_id", columnDefinition = "BIGINT", nullable = false)
  private TypeProductModel typeProduct;

  @ManyToOne
  @JoinColumn(name = "provider_id", columnDefinition = "BIGINT", nullable = false)
  private ProviderModel provider;
}
