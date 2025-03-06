package com.losconfort.confortstarterrest.helper;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefaultRepository<M extends DefaultModel<I>, I extends Serializable>
    extends JpaRepository<M, I> {}
