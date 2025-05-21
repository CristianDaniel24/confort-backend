package com.losconfort.confort.model.procedure;

import com.losconfort.confort.enums.ProcedureEnum;
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
@Table(name = "procedure")
@EqualsAndHashCode(callSuper = false)
public class ProcedureModel extends DefaultModel<Long> {

  @Serial private static final long serialVersionUID = -1050301443455719872L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", columnDefinition = "VARCHAR(150)", nullable = false)
  private String name;

  @Column(name = "price", columnDefinition = "DECIMAL(10,2)", nullable = false)
  private Double price;

  @Column(name = "description", columnDefinition = "VARCHAR(250)", nullable = false)
  private String description;

  @Column(name = "date", columnDefinition = "TIMESTAMP", nullable = false)
  private Timestamp date;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  private ProcedureEnum status;

  @Column(name = "img_url", columnDefinition = "VARCHAR(2000)")
  private String imgUrl;

  @CreationTimestamp
  @Column(name = "created_at", columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
  private Timestamp createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
  private Timestamp updatedAt;

  @ManyToOne
  @JoinColumn(name = "type_procedure_id", columnDefinition = "BIGINT", nullable = false)
  private TypeProcedureModel typeProcedure;
}
