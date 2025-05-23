package com.losconfort.confort.model.cart;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.losconfort.confort.model.procedure.ServiceModel;
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
@IdClass(ShoppingCartServicePK.class)
@Table(name = "shopping_cart_service")
@EqualsAndHashCode(callSuper = false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ShoppingCartServiceModel extends DefaultModel<ShoppingCartServicePK> {

  @Serial private static final long serialVersionUID = -3301840496521415417L;

  @Id
  @ManyToOne
  @JsonBackReference
  @JoinColumn(name = "shopping_cart_id", columnDefinition = "BIGINT", nullable = false)
  private ShoppingCartModel shoppingCart;

  @Id
  @ManyToOne
  @JoinColumn(name = "service_id", columnDefinition = "BIGINT", nullable = false)
  private ServiceModel service;

  @Column(nullable = false, columnDefinition = "integer default 1")
  private Integer amount = 1;

  @CreationTimestamp
  @Column(name = "created_at", columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
  private Timestamp createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
  private Timestamp updatedAt;

  @Override
  public ShoppingCartServicePK getId() {
    return new ShoppingCartServicePK(this.shoppingCart, this.service);
  }

  @Override
  public void setId(ShoppingCartServicePK id) {
    this.shoppingCart = id.getShoppingCart();
    this.service = id.getService();
  }
}
