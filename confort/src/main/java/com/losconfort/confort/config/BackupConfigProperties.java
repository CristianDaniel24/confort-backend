package com.losconfort.confort.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spring.backup")
public class BackupConfigProperties {

  private String dir;
}
