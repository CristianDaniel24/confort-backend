package com.losconfort.confortstarterrest.helper;

import java.io.Serializable;

public interface DefaultService<M extends DefaultModel<I>, I extends Serializable> {
  Iterable<M> list();

  M create(M model);

  M read(I id);

  M update(I id, M model);

  M delete(I id);
}