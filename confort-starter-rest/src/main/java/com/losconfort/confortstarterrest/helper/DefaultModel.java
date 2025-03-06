package com.losconfort.confortstarterrest.helper;

import java.io.Serializable;
import lombok.Data;

@Data
public abstract class DefaultModel<I extends Serializable> implements Serializable {
  private I id;
}
