package com.losconfort.confortstarterrest.helper;

import java.io.Serializable;
import java.sql.Timestamp;
import lombok.Data;

@Data
public abstract class DefaultModel<I extends Serializable> implements Serializable {
  private I id;

  private Timestamp createdAt;

  private Timestamp updatedAt;
}
