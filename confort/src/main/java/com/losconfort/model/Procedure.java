package com.losconfort.model;

import com.losconfort.confortstarterrest.helper.DefaultModel;
import com.losconfort.enums.ProcedureEnum;
import jakarta.persistence.*;
import java.io.Serial;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "procedure")
@EqualsAndHashCode(callSuper = false)
public class Procedure extends DefaultModel<Long> {

  @Serial private static final long serialVersionUID = -4757994939080143249L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "type", columnDefinition = "VARCHAR(150)", nullable = false)
  private String type;

  @Column(name = "description", columnDefinition = "VARCHAR(250)", nullable = false)
  private String description;

  @Column(name = "date", columnDefinition = "TIMESTAMP", nullable = false)
  private LocalDateTime date;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", columnDefinition = "STRING", nullable = false)
  private ProcedureEnum status;

  @Column(
      name = "person_creation_id",
      columnDefinition = "BIGINT",
      nullable = false,
      updatable = false)
  private LocalDateTime personCreationId;

  @Column(name = "person_modification_id", columnDefinition = "BIGINT")
  private LocalDateTime personModificationId;

  @ManyToOne
  @JoinColumn(name = "service_id", columnDefinition = "BIGINT", nullable = false)
  private Service service;

  @ManyToOne
  @JoinColumn(name = "procedure_id", columnDefinition = "BIGINT", nullable = false)
  private TypeProcedure procedureId;
}
