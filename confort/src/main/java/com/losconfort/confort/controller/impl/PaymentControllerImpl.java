package com.losconfort.confort.controller.impl;

import com.losconfort.confort.controller.PaymentController;
import com.losconfort.confort.model.PaymentModel;
import com.losconfort.confort.service.PaymentService;
import com.losconfort.confortstarterrest.helper.DefaultControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentControllerImpl extends DefaultControllerImpl<PaymentModel, Long, PaymentService>
    implements PaymentController {
  public PaymentControllerImpl(PaymentService service) {
    super(service);
  }
}
