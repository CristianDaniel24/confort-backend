package com.losconfort.confort.repository.procedure;

import com.losconfort.confort.model.procedure.ProcedureModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedureRepository extends DefaultRepository<ProcedureModel, Long> {}
