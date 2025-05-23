package com.losconfort.confort.service.impl.cart;

import com.losconfort.confort.model.cart.ShoppingCartModel;
import com.losconfort.confort.model.cart.ShoppingCartServiceModel;
import com.losconfort.confort.model.cart.ShoppingCartServicePK;
import com.losconfort.confort.model.procedure.ServiceModel;
import com.losconfort.confort.repository.cart.ShoppingCartServiceRepository;
import com.losconfort.confort.service.cart.ShoppingCartService;
import com.losconfort.confort.service.cart.ShoppingCartServiceService;
import com.losconfort.confort.service.procedure.ServiceService;
import com.losconfort.confortstarterrest.exception.ShoppingCartException;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import java.util.List;
import java.util.Optional;
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

    ShoppingCartModel shoppingCart =
        this.shoppingCartService.getShoppingCartByPersonId(
            model.getId().getShoppingCart().getClient().getPerson().getId());

    ServiceModel service = getService(model);

    ShoppingCartServicePK pk = new ShoppingCartServicePK(shoppingCart, service);
    Optional<ShoppingCartServiceModel> existing = repository.findById(pk);

    if (existing.isPresent()) {
      ShoppingCartServiceModel existingItem = existing.get();
      existingItem.setAmount(existingItem.getAmount() + 1);
      return repository.save(existingItem);
    }
    pk.setShoppingCart(getShoppingCart(model));
    pk.setService(getService(model));
    model.setId(pk);

    return repository.save(model);
  }

  public Double calculateTotalPrice(Long clientId) {
    ShoppingCartModel shoppingCart = this.shoppingCartService.getShoppingCartByPersonId(clientId);
    List<ShoppingCartServiceModel> items = repository.findByShoppingCart_Id(shoppingCart.getId());

    return items.stream()
        .mapToDouble(
            item -> {
              Double price = item.getId().getService().getProcedure().getPrice();
              Integer amount = item.getAmount();
              return (price != null ? price : 0) * (amount != null ? amount : 0);
            })
        .sum();
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

  @Override
  public List<ShoppingCartServiceModel> findByClientId(Long clientId) {
    ShoppingCartModel activeCart = this.shoppingCartService.getShoppingCartByPersonId(clientId);
    return this.repository.findByShoppingCart_Id(activeCart.getId());
  }

  @Override
  public ShoppingCartServiceModel delete(Long clientId, Long serviceId) {
    ShoppingCartModel shoppingCart = this.shoppingCartService.getShoppingCartByPersonId(clientId);

    ServiceModel service = this.serviceService.findById(serviceId);

    ShoppingCartServicePK pk = new ShoppingCartServicePK(shoppingCart, service);

    ShoppingCartServiceModel cartService =
        repository
            .findById(pk)
            .orElseThrow(() -> new ShoppingCartException("El servicio no esta en el carrito"));
    repository.deleteById(pk);

    return cartService;
  }
}
