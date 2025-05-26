package com.losconfort.confort.dto;

import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordDTO implements Serializable {

  @Serial private static final long serialVersionUID = -2577042290259084988L;

  private String password;

  private String code;
}
