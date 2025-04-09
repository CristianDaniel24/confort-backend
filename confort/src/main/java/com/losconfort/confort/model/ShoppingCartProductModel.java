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
@Table(name = "shopping_cart_product")
@EqualsAndHashCode(callSuper = false)
public class ShoppingCartProductModel extends DefaultModel<ShoppingCartProductPK> {

  @Serial private static final long serialVersionUID = -6027083951113889999L;

  @EmbeddedId private ShoppingCartProductPK id;

  @Column(name = "amount", columnDefinition = "BIGINT", nullable = false)
  private Integer amount;

  @CreationTimestamp
  @Column(name = "created_at", columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
  private Timestamp createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
  private Timestamp updatedAt;
}
