package com.losconfort.confort.model.cart;

import com.losconfort.confort.model.provider.ProductModel;
import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartProductPK implements Serializable {

  @Serial private static final long serialVersionUID = -2837262784790571175L;

  private ShoppingCartModel shoppingCart;

  private ProductModel product;
}
