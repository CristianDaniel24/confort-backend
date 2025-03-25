package com.losconfort.confort.model;

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
@Table(name = "shopping_cart")
@EqualsAndHashCode(callSuper = false)
public class ShoppingCartModel extends DefaultModel<Long> {

  @Serial private static final long serialVersionUID = 5609967024250340655L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JoinColumn(name = "client_id", columnDefinition = "BIGINT", nullable = false)
  private ClientModel client;
}
