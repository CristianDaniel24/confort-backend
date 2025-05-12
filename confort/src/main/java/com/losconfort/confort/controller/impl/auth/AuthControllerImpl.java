package com.losconfort.confort.controller.impl.auth;

import com.losconfort.confort.controller.auth.AuthController;
import com.losconfort.confort.dto.LoginRequestDTO;
import com.losconfort.confort.dto.LoginResponseDTO;
import com.losconfort.confort.service.PersonService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthControllerImpl implements AuthController {

  private final PersonService authService;

  @Override
  @PostMapping("/signin")
  public ResponseEntity<LoginResponseDTO> signin(@Valid @RequestBody LoginRequestDTO loginRequest) {
    return ResponseEntity.status(HttpStatus.OK).body(this.authService.signin(loginRequest));
  }
}
