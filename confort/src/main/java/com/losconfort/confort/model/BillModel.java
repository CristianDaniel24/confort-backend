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
@Table(name = "bill")
@EqualsAndHashCode(callSuper = false)
public class BillModel extends DefaultModel<Long> {

  @Serial private static final long serialVersionUID = -4190662634831554926L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "date", columnDefinition = "TIMESTAMP", nullable = false)
  private Timestamp date;

  @Column(name = "cost_total", columnDefinition = "DECIMAL(10,2)", nullable = false)
  private Double costTotal;

  @OneToOne
  @JoinColumn(name = "shopping_cart_id", columnDefinition = "BIGINT", nullable = false)
  private ShoppingCartModel shoppingCart;

  @CreationTimestamp
  @Column(name = "created_at", columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
  private Timestamp createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
  private Timestamp updatedAt;
}
