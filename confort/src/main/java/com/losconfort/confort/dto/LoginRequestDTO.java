package com.losconfort.confort.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO implements Serializable {

  @Serial private static final long serialVersionUID = 2415422385194778465L;

  @Size(min = 4, message = "El email debe ser valido")
  @NotBlank(message = "Es requerido")
  private String email;

  @NotBlank private String password;
}
