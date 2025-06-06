package com.losconfort.confort.service.impl.procedure;

import com.losconfort.confort.model.procedure.ProcedureModel;
import com.losconfort.confort.repository.procedure.ProcedureRepository;
import com.losconfort.confort.service.procedure.ProcedureService;
import com.losconfort.confortstarterrest.exception.ResourceNotFoundException;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProcedureServiceImpl
    extends DefaultServiceImpl<ProcedureModel, Long, ProcedureRepository>
    implements ProcedureService {
  public ProcedureServiceImpl(ProcedureRepository repository) {
    super(repository);
  }

  @Override
  public ProcedureModel create(ProcedureModel model) {
    if (this.repository.existsByName(model.getName())) {
      throw new ResourceNotFoundException("Ya existe un procedimiento registrado con ese nombre");
    }
    return super.create(model);
  }

  @Override
  public ProcedureModel update(Long id, ProcedureModel model) {
    if (this.repository.existsByName(model.getName())) {
      throw new ResourceNotFoundException("No puedes editar el procedimiento con el mismo nombre");
    }
    return super.update(id, model);
  }
}
