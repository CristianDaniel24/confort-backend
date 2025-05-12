package com.losconfort.confort.controller.impl.procedure;

import com.losconfort.confort.controller.procedure.TypeProcedureController;
import com.losconfort.confort.model.procedure.TypeProcedureModel;
import com.losconfort.confort.service.procedure.TypeProcedureService;
import com.losconfort.confortstarterrest.helper.DefaultControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/type-procedure")
public class TypeProcedureControllerImpl
    extends DefaultControllerImpl<TypeProcedureModel, Long, TypeProcedureService>
    implements TypeProcedureController {
  public TypeProcedureControllerImpl(TypeProcedureService service) {
    super(service);
  }
}
