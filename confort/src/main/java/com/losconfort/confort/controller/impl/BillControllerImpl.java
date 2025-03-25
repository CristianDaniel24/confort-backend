package com.losconfort.confort.controller.impl;

import com.losconfort.confort.controller.BillController;
import com.losconfort.confort.model.BillModel;
import com.losconfort.confort.service.BillService;
import com.losconfort.confortstarterrest.helper.DefaultControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillControllerImpl extends DefaultControllerImpl<BillModel, Long, BillService>
    implements BillController {
  public BillControllerImpl(BillService service) {
    super(service);
  }
}
