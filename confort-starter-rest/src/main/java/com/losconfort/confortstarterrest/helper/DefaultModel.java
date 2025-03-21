package com.losconfort.confortstarterrest.helper;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class DefaultModel<I extends Serializable> implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private I id;

  @Column(columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
  private Timestamp createdAt;

  @Column(columnDefinition = "TIMESTAMP", updatable = false)
  private Timestamp updatedAt;

  @Column(columnDefinition = "TIMESTAMP", updatable = false)
  private Timestamp deletedAt;
}
