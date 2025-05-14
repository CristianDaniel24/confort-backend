package com.losconfort.confort.model.cart;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.losconfort.confort.model.provider.ProductModel;
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
@IdClass(ShoppingCartProductPK.class)
@Table(name = "shopping_cart_product")
@EqualsAndHashCode(callSuper = false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ShoppingCartProductModel extends DefaultModel<ShoppingCartProductPK> {

  @Serial private static final long serialVersionUID = -6027083951113889999L;

  @Id
  @ManyToOne
  @JsonBackReference
  @JoinColumn(name = "shopping_cart_id", columnDefinition = "BIGINT", nullable = false)
  private ShoppingCartModel shoppingCart;

  @Id
  @ManyToOne
  @JoinColumn(name = "product_id", columnDefinition = "BIGINT", nullable = false)
  private ProductModel product;

  @Column(name = "amount", columnDefinition = "BIGINT", nullable = false)
  private Integer amount;

  @CreationTimestamp
  @Column(name = "created_at", columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
  private Timestamp createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
  private Timestamp updatedAt;

  @Override
  public ShoppingCartProductPK getId() {
    return new ShoppingCartProductPK(this.shoppingCart, this.product);
  }

  @Override
  public void setId(ShoppingCartProductPK id) {
    this.shoppingCart = id.getShoppingCart();
    this.product = id.getProduct();
  }
}
