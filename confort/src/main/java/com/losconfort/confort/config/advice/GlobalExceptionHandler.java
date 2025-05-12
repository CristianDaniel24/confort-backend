package com.losconfort.confort.config.advice;

import com.losconfort.confortstarterrest.dto.ErrorResponseDTO;
import com.losconfort.confortstarterrest.enums.ErrorCodeEnum;
import com.losconfort.confortstarterrest.exception.ResourceNotFoundException;
import com.losconfort.confortstarterrest.exception.UniqueConstraintViolationException;
import org.hibernate.PropertyValueException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  ResponseEntity<ErrorResponseDTO> handleResourceNotFound(ResourceNotFoundException ex) {
    ErrorResponseDTO error =
        new ErrorResponseDTO(
            ex.getMessage(), HttpStatus.NOT_FOUND.value(), ErrorCodeEnum.RESOURCE_NOT_FOUND);
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }

  @ExceptionHandler(UniqueConstraintViolationException.class)
  ResponseEntity<ErrorResponseDTO> handleUniqueConstraintViolation(
      UniqueConstraintViolationException ex) {
    ErrorResponseDTO error =
        new ErrorResponseDTO(
            ex.getMessage(),
            HttpStatus.BAD_REQUEST.value(),
            ErrorCodeEnum.UNIQUE_CONSTRAINT_VIOLATION);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }

  @ExceptionHandler({PropertyValueException.class, DataIntegrityViolationException.class})
  ResponseEntity<ErrorResponseDTO> handlePropertyValueException(PropertyValueException ex) {
    ErrorResponseDTO error =
        new ErrorResponseDTO(
            "Invalid payload", HttpStatus.BAD_REQUEST.value(), ErrorCodeEnum.INVALID_PAYLOAD);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }
}
