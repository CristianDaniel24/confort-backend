package com.losconfort.confort.controller.impl.payment;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.losconfort.confort.controller.payment.BillController;
import com.losconfort.confort.model.payment.BillModel;
import com.losconfort.confort.service.payment.BillService;
import com.losconfort.confortstarterrest.helper.DefaultControllerImpl;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillControllerImpl extends DefaultControllerImpl<BillModel, Long, BillService>
    implements BillController {
  public BillControllerImpl(BillService service) {
    super(service);
  }

  @Override
  @GetMapping(path = "client/{id}", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<List<BillModel>> getBillByPersonId(@PathVariable("id") Long personId) {
    return ResponseEntity.ok(this.service.getBillByPersonId(personId));
  }
}
