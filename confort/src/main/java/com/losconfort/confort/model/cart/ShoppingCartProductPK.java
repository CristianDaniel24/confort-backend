package com.losconfort.confort.model.cart;

import com.losconfort.confort.model.provider.ProductModel;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartProductPK implements Serializable {

  @Serial private static final long serialVersionUID = -2837262784790571175L;

  @ManyToOne
  @JoinColumn(name = "shopping_cart_id", columnDefinition = "BIGINT", nullable = false)
  private ShoppingCartModel shoppingCart;

  @ManyToOne
  @JoinColumn(name = "product_id", columnDefinition = "BIGINT", nullable = false)
  private ProductModel product;
}
