package com.losconfort.confort.controller.impl.provider;

import com.losconfort.confort.controller.provider.ProviderController;
import com.losconfort.confort.model.provider.ProviderModel;
import com.losconfort.confort.service.provider.ProviderService;
import com.losconfort.confortstarterrest.helper.DefaultControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class ProviderControllerImpl
    extends DefaultControllerImpl<ProviderModel, Long, ProviderService>
    implements ProviderController {
  public ProviderControllerImpl(ProviderService service) {
    super(service);
  }
}
