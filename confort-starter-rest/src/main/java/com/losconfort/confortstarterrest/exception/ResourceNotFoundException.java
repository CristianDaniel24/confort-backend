package com.losconfort.confortstarterrest.exception;

public class ResourceNotFoundException extends RuntimeException {

  public ResourceNotFoundException() {
    super("User not found");
  }

  public ResourceNotFoundException(String message) {
    super(message);
  }
}
