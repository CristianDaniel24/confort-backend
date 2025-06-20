package com.losconfort.confort.service;

import com.losconfort.confort.dto.ChangePasswordDTO;
import com.losconfort.confort.dto.LoginRequestDTO;
import com.losconfort.confort.dto.LoginResponseDTO;
import com.losconfort.confort.dto.UserEmailDTO;
import com.losconfort.confort.model.PersonModel;
import com.losconfort.confortstarterrest.helper.DefaultService;

public interface PersonService extends DefaultService<PersonModel, Long> {

  LoginResponseDTO signin(LoginRequestDTO loginRequest);

  UserEmailDTO recoverPassword(UserEmailDTO model);

  ChangePasswordDTO changePassword(ChangePasswordDTO model);
}
