package com.losconfort.confort.service.impl;

import com.losconfort.confort.model.ShoppingCartModel;
import com.losconfort.confort.repository.ShoppingCartRepository;
import com.losconfort.confort.service.ShoppingCartService;
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
