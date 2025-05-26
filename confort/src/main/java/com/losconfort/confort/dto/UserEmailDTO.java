package com.losconfort.confort.dto;

import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEmailDTO implements Serializable {

  @Serial private static final long serialVersionUID = 6897959956922329215L;

  private String email;
}
