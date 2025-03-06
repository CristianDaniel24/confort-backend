package com.losconfort.confortstarterrest.helper;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.io.Serializable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface DefaultController<M extends DefaultModel<I>, I extends Serializable> {

  @GetMapping(produces = APPLICATION_JSON_VALUE)
  ResponseEntity<Iterable<M>> list();

  @PostMapping(produces = APPLICATION_JSON_VALUE)
  ResponseEntity<M> create(@RequestBody M model);

  @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
  ResponseEntity<M> read(@PathVariable I id);

  @PutMapping(path = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  ResponseEntity<M> update(@PathVariable I id, @RequestBody M model);

  @DeleteMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
  ResponseEntity<M> delete(@PathVariable I id);
}
