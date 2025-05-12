package com.losconfort.confort.controller.impl;

import com.losconfort.confort.controller.RolController;
import com.losconfort.confort.model.RolModel;
import com.losconfort.confort.service.RolService;
import com.losconfort.confortstarterrest.helper.DefaultControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rol")
public class RolControllerImpl extends DefaultControllerImpl<RolModel, Long, RolService>
    implements RolController {
  public RolControllerImpl(RolService service) {
    super(service);
  }
}
