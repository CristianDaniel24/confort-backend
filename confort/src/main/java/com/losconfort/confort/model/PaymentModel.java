package com.losconfort.confort.model;

import com.losconfort.confort.enums.PaymentEnum;
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
@Table(name = "payment")
@EqualsAndHashCode(callSuper = false)
public class PaymentModel extends DefaultModel<Long> {

  @Serial private static final long serialVersionUID = 248201153869792766L;

  @Id
  @Column(name = "bill_id")
  private Long id;

  @OneToOne
  @JoinColumn(name = "bill_id", columnDefinition = "BIGINT", insertable = false, updatable = false)
  private BillModel bill;

  @Enumerated(EnumType.STRING)
  @Column(name = "method", nullable = false)
  private PaymentEnum method;
}
