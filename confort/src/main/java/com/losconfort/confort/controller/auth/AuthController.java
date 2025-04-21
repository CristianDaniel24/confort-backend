package com.losconfort.confort.controller.auth;

import com.losconfort.confort.dto.LoginRequestDTO;
import com.losconfort.confort.dto.LoginResponseDTO;
import org.springframework.http.ResponseEntity;

public interface AuthController {

  ResponseEntity<LoginResponseDTO> signin(LoginRequestDTO loginRequest);
}
