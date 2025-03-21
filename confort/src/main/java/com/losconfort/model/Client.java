package com.losconfort.model;

import com.losconfort.confortstarterrest.helper.DefaultModel;
import jakarta.persistence.*;
import java.io.Serial;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client")
@EqualsAndHashCode(callSuper = false)
public class Client extends DefaultModel<Long> {

  @Serial private static final long serialVersionUID = -969415857032911750L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JoinColumn(name = "person_id", columnDefinition = "BIGINT", nullable = false)
  private Person person;

  @OneToOne
    @JoinColumn(name = "shopping_cart_id", columnDefinition = "BIGINT", nullable = false)
    private ShoppingCart shoppingCart;
}
