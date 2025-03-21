package com.losconfort.model;

import com.losconfort.confortstarterrest.helper.DefaultModel;
import com.losconfort.enums.PaymentEnum;
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
@Table(name = "payment")
@EqualsAndHashCode(callSuper = false)
public class Payment extends DefaultModel<Long> {

  @Serial private static final long serialVersionUID = 248201153869792766L;

  // COMO VA EL ID??

  @Enumerated(EnumType.STRING)
  @Column(name = "method", columnDefinition = "STRING", nullable = false)
  private PaymentEnum method;

  @Column(
      name = "person_creation_id",
      columnDefinition = "BIGINT",
      nullable = false,
      updatable = false)
  private Long personCreationId;

  @Column(name = "person_modification_id", columnDefinition = "BIGINT")
  private Long personModificationId;
}
