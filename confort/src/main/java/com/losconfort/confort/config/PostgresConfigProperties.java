package com.losconfort.confort.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "postgres")
public class PostgresConfigProperties {
  private String user;
  private String password;
  private String db;
  private String host;
  private String port;
  private String pgDumpPath;
  private String psqlPath;
}
