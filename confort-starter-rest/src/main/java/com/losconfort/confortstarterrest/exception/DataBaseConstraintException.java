package com.losconfort.confortstarterrest.exception;

public class DataBaseConstraintException extends RuntimeException {

  public DataBaseConstraintException() {
    super("Lo que se desea eliminar no es posible porque ya tiene registros en otro lugar =(");
  }

  public DataBaseConstraintException(String message) {
    super(message);
  }
}
