package com.losconfort.confortstarterrest.helper;

import com.losconfort.confortstarterrest.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import java.io.Serializable;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class DefaultServiceImpl<
        M extends DefaultModel<I>, I extends Serializable, R extends DefaultRepository<M, I>>
    implements DefaultService<M, I> {

  protected final R repository;

  @Override
  public Iterable<M> list() {
    return this.repository.findAll();
  }

  @Override
  @Transactional
  public M create(M model) {
    model.setId(null);
    return this.repository.save(model);
  }

  @Override
  public M read(I id) {
    return this.repository.findById(id).orElseThrow(ResourceNotFoundException::new);
  }

  @Override
  @Transactional
  public M update(I id, M model) {
    if (!this.repository.existsById(id)) {
      throw new ResourceNotFoundException();
    }
    model.setId(id);
    return this.repository.save(model);
  }

  @Override
  public M delete(I id) {
    M model = this.repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    this.repository.delete(model);
    return model;
  }
}
