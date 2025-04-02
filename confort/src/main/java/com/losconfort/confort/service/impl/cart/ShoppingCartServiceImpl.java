package com.losconfort.confort.service.impl.cart;

import com.losconfort.confort.model.cart.ShoppingCartModel;
import com.losconfort.confort.repository.cart.ShoppingCartRepository;
import com.losconfort.confort.service.cart.ShoppingCartService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl
    extends DefaultServiceImpl<ShoppingCartModel, Long, ShoppingCartRepository>
    implements ShoppingCartService {
  public ShoppingCartServiceImpl(ShoppingCartRepository repository) {
    super(repository);
  }
}
