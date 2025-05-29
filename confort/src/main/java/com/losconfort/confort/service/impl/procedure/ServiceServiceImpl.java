package com.losconfort.confort.service.impl.procedure;

import com.losconfort.confort.enums.ServiceEnum;
import com.losconfort.confort.model.PersonModel;
import com.losconfort.confort.model.cart.ShoppingCartModel;
import com.losconfort.confort.model.cart.ShoppingCartServiceModel;
import com.losconfort.confort.model.cart.ShoppingCartServicePK;
import com.losconfort.confort.model.procedure.ServiceModel;
import com.losconfort.confort.repository.procedure.ServiceRepository;
import com.losconfort.confort.service.cart.ShoppingCartService;
import com.losconfort.confort.service.cart.ShoppingCartServiceService;
import com.losconfort.confort.service.procedure.ServiceService;
import com.losconfort.confortstarterrest.exception.ResourceNotFoundException;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiceImpl extends DefaultServiceImpl<ServiceModel, Long, ServiceRepository>
    implements ServiceService {

  private final ShoppingCartService shoppingCartService;
  private final ShoppingCartServiceService shoppingCartServiceService;

  public ServiceServiceImpl(
      ServiceRepository repository,
      ShoppingCartService shoppingCartService,
      @Lazy ShoppingCartServiceService shoppingCartServiceService) {
    super(repository);
    this.shoppingCartService = shoppingCartService;
    this.shoppingCartServiceService = shoppingCartServiceService;
  }

  @Override
  public ServiceModel create(ServiceModel model) {
    model.setStatus(ServiceEnum.CREADO);
    return super.create(model);
  }

  @Override
  public ServiceModel update(Long id, ServiceModel model) {
    model.setId(id);
    if (model.getStatus() == ServiceEnum.APROBADO) {
      PersonModel person = this.repository.findPersonByServiceId(id);

      if (person == null) {
        throw new ResourceNotFoundException("No se encontro a la persona usando el servicio " + id);
      }

      // Buscar el carrito del cliente, el metodo getShoppingCartByPersonId ya lo crea si no existe
      ShoppingCartModel shoppingCart =
          this.shoppingCartService.getShoppingCartByPersonId(person.getId());

      // Crear el ShoppingCartService
      ShoppingCartServiceModel scService = new ShoppingCartServiceModel();
      scService.setShoppingCart(shoppingCart);
      scService.setService(model);
      // Se crea la Pk del ShoppingCartService
      ShoppingCartServicePK pk = new ShoppingCartServicePK(shoppingCart, model);
      scService.setId(pk);

      // Despues de setear el ShoppingCartService, se crea usando el servicio
      this.shoppingCartServiceService.create(scService);
    }
    return super.update(id, model);
  }

  @Override
  public ServiceModel findById(Long id) {
    return this.repository
        .findById(id)
        .orElseThrow(
            () -> new ResourceNotFoundException("Servicio con id " + id + " no encontrado"));
  }

  @Override
  public Long pendingOrders() {
    return this.repository.countCreatedServices(ServiceEnum.CREADO);
  }

  @Override
  public ServiceModel newService() {
    return this.repository.findTopByStatusOrderByCreatedAtDesc(ServiceEnum.CREADO);
  }
}
