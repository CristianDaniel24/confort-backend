package com.losconfort.confort.service.impl.procedure;

import com.losconfort.confort.model.procedure.ProcedureModel;
import com.losconfort.confort.repository.procedure.ProcedureRepository;
import com.losconfort.confort.service.procedure.ProcedureService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProcedureServiceImpl
    extends DefaultServiceImpl<ProcedureModel, Long, ProcedureRepository>
    implements ProcedureService {
  public ProcedureServiceImpl(ProcedureRepository repository) {
    super(repository);
  }
}
