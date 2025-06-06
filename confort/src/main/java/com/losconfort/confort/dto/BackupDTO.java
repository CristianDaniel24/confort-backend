package com.losconfort.confort.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BackupDTO implements Serializable {

  @Serial private static final long serialVersionUID = 3733225830524364335L;

  private String fileName;

  private Long size;

  private Date createdAt;
}
