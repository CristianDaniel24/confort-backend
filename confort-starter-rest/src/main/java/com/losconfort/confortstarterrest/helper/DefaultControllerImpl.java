package com.losconfort.confortstarterrest.helper;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
public abstract class DefaultControllerImpl<
        M extends DefaultModel<I>, I extends Serializable, S extends DefaultService<M, I>>
    implements DefaultController<M, I> {

  protected final S service;

  @Override
  public ResponseEntity<Iterable<M>> list() {
    return ResponseEntity.status(HttpStatus.OK).body(this.service.list());
  }

  @OverrideCREATED).body(this.service.create(model));
  }

  @Override
  public ResponseEntity<M
public ResponseEntity<M> create(M model) {
  return ResponseEntity.status(HttpStatus.> read(I id) {
    return ResponseEntity.status(HttpStatus.OK).body(this.service.read(id));
  }

  @Override
  public ResponseEntity<M> update(I id, M model) {
    return ResponseEntity.status(HttpStatus.OK).body(this.service.update(id, model));
  }

  @Override
  public ResponseEntity<M> delete(I id) {
    return ResponseEntity.status(HttpStatus.OK).body(this.service.delete(id));
  }
}
