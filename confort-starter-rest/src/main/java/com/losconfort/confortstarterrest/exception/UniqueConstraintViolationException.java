package com.losconfort.confortstarterrest.exception;

public class UniqueConstraintViolationException extends RuntimeException {
  public UniqueConstraintViolationException(String message) {
    super(message);
  }

  public UniqueConstraintViolationException(String message, Throwable cause) {
    super(message, cause);
  }
}
