package com.losconfort.confort.model;

import com.losconfort.confort.model.cart.ShoppingCartModel;
import com.losconfort.confort.model.procedure.ServiceModel;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartServicePK implements Serializable {

  @Serial private static final long serialVersionUID = 539612924531504538L;

  @ManyToOne
  @JoinColumn(name = "service_id", columnDefinition = "BIGINT", nullable = false)
  private ServiceModel service;

  @ManyToOne
  @JoinColumn(name = "shopping_cart_id", columnDefinition = "BIGINT", nullable = false)
  private ShoppingCartModel shoppingCart;
}
