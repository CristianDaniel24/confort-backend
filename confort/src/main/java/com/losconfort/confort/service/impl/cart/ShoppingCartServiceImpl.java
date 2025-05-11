package com.losconfort.confort.service.impl.cart;

import com.losconfort.confort.enums.ShoppingCartEnum;
import com.losconfort.confort.model.ClientModel;
import com.losconfort.confort.model.cart.ShoppingCartModel;
import com.losconfort.confort.repository.ClientRepository;
import com.losconfort.confort.repository.cart.ShoppingCartRepository;
import com.losconfort.confort.service.cart.ShoppingCartService;
import com.losconfort.confortstarterrest.exception.ResourceNotFoundException;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl
    extends DefaultServiceImpl<ShoppingCartModel, Long, ShoppingCartRepository>
    implements ShoppingCartService {

  private final ClientRepository clientRepository;

  public ShoppingCartServiceImpl(
      ShoppingCartRepository repository, ClientRepository clientRepository) {
    super(repository);
    this.clientRepository = clientRepository;
  }

  @Override
  public ShoppingCartModel getShoppingCartByPersonId(Long personId) {

    Optional<ShoppingCartModel> shoppingCart =
        this.repository.findActiveShoppingCartByPersonId(personId);
    if (shoppingCart.isPresent()) {
      return shoppingCart.get();
    } else {
      ClientModel client =
          this.clientRepository
              .findByPersonId(personId)
              .orElseThrow(() -> new ResourceNotFoundException("El cliente no se encontro!"));

      ShoppingCartModel newCart = new ShoppingCartModel();
      newCart.setClient(client);
      newCart.setStatus(ShoppingCartEnum.ACTIVO);
      return this.repository.save(newCart);
    }
  }

  @Override
  public ShoppingCartModel confirmOrder(Long personId) {
    Optional<ShoppingCartModel> shoppingCart =
        this.repository.findActiveShoppingCartByPersonId(personId);

    // Aqui se setea el estado CONFIRMADO para el carrito
    // Aqui se llama el service de Bill para crear un Bill
    return null;
  }
}
