package com.losconfort.confort.controller.impl.procedure;

import com.losconfort.confort.controller.procedure.ProcedureController;
import com.losconfort.confort.model.procedure.ProcedureModel;
import com.losconfort.confort.service.procedure.ProcedureService;
import com.losconfort.confortstarterrest.helper.DefaultControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/procedure")
public class ProcedureControllerImpl
    extends DefaultControllerImpl<ProcedureModel, Long, ProcedureService>
    implements ProcedureController {
  public ProcedureControllerImpl(ProcedureService service) {
    super(service);
  }
}
