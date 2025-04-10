package com.losconfort.confort.service.impl.cart;

import com.losconfort.confort.model.cart.ShoppingCartModel;
import com.losconfort.confort.model.cart.ShoppingCartServiceModel;
import com.losconfort.confort.model.cart.ShoppingCartServicePK;
import com.losconfort.confort.model.procedure.ServiceModel;
import com.losconfort.confort.repository.ShoppingCartServiceRepository;
import com.losconfort.confort.repository.cart.ShoppingCartRepository;
import com.losconfort.confort.repository.procedure.ServiceRepository;
import com.losconfort.confort.service.cart.ShoppingCartServiceService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceServiceImpl
    extends DefaultServiceImpl<
        ShoppingCartServiceModel, ShoppingCartServicePK, ShoppingCartServiceRepository>
    implements ShoppingCartServiceService {

  private final ShoppingCartRepository shoppingCartRepository;
  private final ServiceRepository serviceRepository;

  public ShoppingCartServiceServiceImpl(
      ShoppingCartServiceRepository repository,
      ShoppingCartRepository shoppingCartRepository,
      ServiceRepository serviceRepository) {
    super(repository);
    this.shoppingCartRepository = shoppingCartRepository;
    this.serviceRepository = serviceRepository;
  }

  @Override
  public ShoppingCartServiceModel create(ShoppingCartServiceModel model) {
    Long shoppingCartId =
        model.getId() != null && model.getId().getShoppingCart() != null
            ? model.getId().getShoppingCart().getId()
            : null;

    Long serviceId =
        model.getId() != null && model.getId().getService() != null
            ? model.getId().getService().getId()
            : null;

    if (shoppingCartId == null || serviceId == null) {
      throw new RuntimeException("ID de shoppingCart o Service es null");
    }

    ShoppingCartModel shoppingCart =
        shoppingCartRepository
            .findById(shoppingCartId)
            .orElseThrow(() -> new RuntimeException("ShoppingCart no encontrado"));

    ServiceModel service =
        serviceRepository
            .findById(serviceId)
            .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));

    ShoppingCartServicePK pk = new ShoppingCartServicePK();
    pk.setShoppingCart(shoppingCart);
    pk.setService(service);
    model.setId(pk);

    return repository.save(model);
  }
}
