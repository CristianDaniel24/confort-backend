package com.losconfort.confort.controller.auth;

import com.losconfort.confort.dto.ChangePasswordDTO;
import com.losconfort.confort.dto.LoginRequestDTO;
import com.losconfort.confort.dto.LoginResponseDTO;
import com.losconfort.confort.dto.UserEmailDTO;
import org.springframework.http.ResponseEntity;

public interface AuthController {

  ResponseEntity<LoginResponseDTO> signin(LoginRequestDTO loginRequest);

  ResponseEntity<UserEmailDTO> recoverPassword(UserEmailDTO model);

  ResponseEntity<ChangePasswordDTO> changePassword(ChangePasswordDTO model);
}
