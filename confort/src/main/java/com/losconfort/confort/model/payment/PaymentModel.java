package com.losconfort.confort.model.payment;

import com.losconfort.confort.enums.PaymentEnum;
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
@Table(name = "payment")
@EqualsAndHashCode(callSuper = false)
public class PaymentModel extends DefaultModel<Long> {

  @Serial private static final long serialVersionUID = 248201153869792766L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JoinColumn(name = "bill_id", columnDefinition = "BIGINT", nullable = false)
  private BillModel bill;

  @Enumerated(EnumType.STRING)
  @Column(name = "method", nullable = false)
  private PaymentEnum method;

  @CreationTimestamp
  @Column(name = "created_at", columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
  private Timestamp createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
  private Timestamp updatedAt;
}
