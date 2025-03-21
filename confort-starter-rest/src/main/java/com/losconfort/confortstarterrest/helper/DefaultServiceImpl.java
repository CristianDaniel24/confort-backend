package com.losconfort.confortstarterrest.helper;

import com.losconfort.confortstarterrest.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
    model.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
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
    model.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
    return this.repository.save(model);
  }

  @Override
  public M delete(I id) {
    M model = this.repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    model.setDeletedAt(Timestamp.valueOf(LocalDateTime.now()));
    this.repository.save(model);
    return model;
  }
}
