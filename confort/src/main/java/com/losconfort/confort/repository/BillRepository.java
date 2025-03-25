package com.losconfort.confort.repository;

import com.losconfort.confort.model.BillModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends DefaultRepository<BillModel, Long> {}
