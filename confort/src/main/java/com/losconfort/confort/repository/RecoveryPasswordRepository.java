package com.losconfort.confort.repository;

import com.losconfort.confort.model.RecoveryPasswordModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecoveryPasswordRepository extends DefaultRepository<RecoveryPasswordModel, Long> {

  Optional<RecoveryPasswordModel> findByCode(String code);
}
