package com.losconfort.confort.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class BackupProperties {
  @Value("${backup.dir}")
  private String backupDir;

  @Value("${postgres.user}")
  private String user;

  @Value("${postgres.password}")
  private String password;

  @Value("${postgres.db}")
  private String db;

  @Value("${postgres.host}")
  private String host;

  @Value("${postgres.port}")
  private String port;

  @Value("${postgres.pgDumpPath}")
  private String pgDumpPath;

  @Value("${postgres.psqlPath}")
  private String psqlPath;
}
