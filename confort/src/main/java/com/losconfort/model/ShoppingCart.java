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
@Table(name = "shopping_cart")
@EqualsAndHashCode(callSuper = false)
public class ShoppingCart extends DefaultModel<Long> {

  @Serial private static final long serialVersionUID = 5609967024250340655L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(
      name = "person_creation_id",
      columnDefinition = "BIGINT",
      nullable = false,
      updatable = false)
  private Long personCreationId;

  @Column(name = "person_modification_id", columnDefinition = "BIGINT")
  private Long personModificationId;
}
