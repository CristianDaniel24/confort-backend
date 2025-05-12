package com.losconfort.confort.service.impl.procedure;

import com.losconfort.confort.model.procedure.TypeProcedureModel;
import com.losconfort.confort.repository.procedure.TypeProcedureRepository;
import com.losconfort.confort.service.procedure.TypeProcedureService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TypeProcedureServiceImpl
    extends DefaultServiceImpl<TypeProcedureModel, Long, TypeProcedureRepository>
    implements TypeProcedureService {
  public TypeProcedureServiceImpl(TypeProcedureRepository repository) {
    super(repository);
  }
}
