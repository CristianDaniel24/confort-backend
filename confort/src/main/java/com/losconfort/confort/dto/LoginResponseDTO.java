package com.losconfort.confort.dto;

import com.losconfort.confort.model.PersonModel;
import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDTO implements Serializable {

  @Serial private static final long serialVersionUID = -6454948397332487596L;

  private PersonModel person;

  private String rol;
}
