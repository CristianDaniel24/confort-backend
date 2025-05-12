package com.losconfort.confort.model.cart;

import com.losconfort.confort.enums.ShoppingCartEnum;
import com.losconfort.confort.model.ClientModel;
import com.losconfort.confortstarterrest.helper.DefaultModel;
import jakarta.persistence.*;
import java.io.Serial;
import java.sql.Timestamp;
import java.util.List;
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
@Table(name = "shopping_cart")
@EqualsAndHashCode(callSuper = false)
public class ShoppingCartModel extends DefaultModel<Long> {

  @Serial private static final long serialVersionUID = 5609967024250340655L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  private ShoppingCartEnum status;

  @Transient private List<ShoppingCartProductModel> shoppingCartProduct;

  @OneToOne
  @JoinColumn(name = "client_id", columnDefinition = "BIGINT", nullable = false)
  private ClientModel client;

  @CreationTimestamp
  @Column(name = "created_at", columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
  private Timestamp createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
  private Timestamp updatedAt;
}
