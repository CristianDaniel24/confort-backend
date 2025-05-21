package com.losconfort.confort.model.cart;

import com.losconfort.confort.model.procedure.ServiceModel;
import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartServicePK implements Serializable {

  @Serial private static final long serialVersionUID = 539612924531504538L;

  private ShoppingCartModel shoppingCart;

  private ServiceModel service;
}
