package com.losconfort.confortstarterrest.dto;

import com.losconfort.confortstarterrest.enums.ErrorCodeEnum;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ErrorResponseDTO {
  private String message;
  private LocalDateTime timestamp;
  private int status;
  private ErrorCodeEnum errorCode;

  public ErrorResponseDTO(String message, int status, ErrorCodeEnum errorCode) {
    this.message = message;
    this.timestamp = LocalDateTime.now();
    this.status = status;
    this.errorCode = errorCode;
  }
}
