package com.losconfort.confort.service.impl.cart;

import com.losconfort.confort.model.cart.ShoppingCartModel;
import com.losconfort.confort.model.cart.ShoppingCartServiceModel;
import com.losconfort.confort.model.cart.ShoppingCartServicePK;
import com.losconfort.confort.model.procedure.ServiceModel;
import com.losconfort.confort.repository.cart.ShoppingCartServiceRepository;
import com.losconfort.confort.service.cart.ShoppingCartService;
import com.losconfort.confort.service.cart.ShoppingCartServiceService;
import com.losconfort.confort.service.procedure.ServiceService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceServiceImpl
    extends DefaultServiceImpl<
        ShoppingCartServiceModel, ShoppingCartServicePK, ShoppingCartServiceRepository>
    implements ShoppingCartServiceService {

  private final ShoppingCartService shoppingCartService;
  private final ServiceService serviceService;

  public ShoppingCartServiceServiceImpl(
      ShoppingCartServiceRepository repository,
      ShoppingCartService shoppingCartService,
      ServiceService serviceService) {
    super(repository);
    this.shoppingCartService = shoppingCartService;
    this.serviceService = serviceService;
  }

  @Override
  public ShoppingCartServiceModel create(ShoppingCartServiceModel model) {

    ShoppingCartServicePK pk = new ShoppingCartServicePK();
    pk.setShoppingCart(getShoppingCart(model));
    pk.setService(getService(model));
    model.setId(pk);

    return repository.save(model);
  }

  private ShoppingCartModel getShoppingCart(ShoppingCartServiceModel model) {
    Long shoppingCartId =
        model.getId() != null && model.getId().getShoppingCart() != null
            ? model.getId().getShoppingCart().getId()
            : null;
    if (shoppingCartId == null) {
      throw new RuntimeException("El ID de shoppingCart es null");
    }
    return shoppingCartService.read(shoppingCartId);
  }

  private ServiceModel getService(ShoppingCartServiceModel model) {
    Long serviceId =
        model.getId() != null && model.getId().getService() != null
            ? model.getId().getService().getId()
            : null;
    if (serviceId == null) {
      throw new RuntimeException("El ID de Service es null");
    }
    return serviceService.read(serviceId);
  }
}
