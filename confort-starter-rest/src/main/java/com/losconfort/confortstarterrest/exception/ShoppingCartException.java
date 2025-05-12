package com.losconfort.confortstarterrest.exception;

public class ShoppingCartException extends RuntimeException {

  public ShoppingCartException() {
    super("Error en la operacion del carrito de compras");
  }

  public ShoppingCartException(String message) {
    super(message);
  }
}
