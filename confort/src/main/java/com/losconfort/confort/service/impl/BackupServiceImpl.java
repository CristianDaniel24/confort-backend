package com.losconfort.confort.service.impl;

import com.losconfort.confort.config.BackupProperties;
import com.losconfort.confort.config.PostgresConfigProperties;
import com.losconfort.confort.dto.BackupDTO;
import com.losconfort.confort.service.BackupService;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BackupServiceImpl implements BackupService {

  private final BackupProperties backupProperties;
  private final PostgresConfigProperties postgresConfig;

  public BackupServiceImpl(
      BackupProperties backupProperties, PostgresConfigProperties postgresConfig) {
    this.backupProperties = backupProperties;
    this.postgresConfig = postgresConfig;
  }

  @Override
  public List<BackupDTO> listBackups() {
    File backupFolder = new File(backupProperties.getBackupDir());
    File[] files = backupFolder.listFiles();

    if (files == null) return Collections.emptyList();

    List<BackupDTO> backups = new ArrayList<>();
    for (File file : files) {
      backups.add(new BackupDTO(file.getName(), file.length(), new Date(file.lastModified())));
    }

    return backups;
  }

  @Override
  public String createBackup() {
    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String filename = String.format("%s_%s.sql", postgresConfig.getDb(), timestamp);
    String filePath = Paths.get(backupProperties.getBackupDir(), filename).toString();

    // Agregamos la opción -c (--clean) para que el dump incluya DROP antes de crear cada objeto.
    String commandLine =
        String.format(
            "cmd.exe /c set PGPASSWORD=%s && \"%s\" -U %s -h %s -p %s -F p -c -f \"%s\" %s",
            postgresConfig.getPassword(),
            postgresConfig.getPgDumpPath(),
            postgresConfig.getUser(),
            postgresConfig.getHost(),
            postgresConfig.getPort(),
            filePath,
            postgresConfig.getDb());

    List<String> command = Arrays.asList("cmd.exe", "/c", commandLine);

    return runProcess(command, "Backup creado exitosamente en: " + filename);
  }

  @Override
  public void restoreBackup(String filename) {
    String filePath = Paths.get(backupProperties.getBackupDir(), filename).toString();

    List<String> command =
        Arrays.asList(
            postgresConfig.getPsqlPath(),
            "-U",
            postgresConfig.getUser(),
            "-h",
            postgresConfig.getHost(),
            "-p",
            postgresConfig.getPort(),
            "-d",
            postgresConfig.getDb(),
            "-f",
            filePath);

    runProcess(command, "Backup restaurado desde: " + filename);
  }

  @Override
  public void importBackup(MultipartFile file) {
    try {
      Path backupDir = Paths.get(backupProperties.getBackupDir());
      if (!Files.exists(backupDir)) {
        Files.createDirectories(backupDir);
      }

      // 1) Generar un nombre único para el archivo importado (para evitar colisiones)
      String originalFilename = file.getOriginalFilename();
      String uniqueName = System.currentTimeMillis() + "_" + originalFilename;
      Path destino = backupDir.resolve(uniqueName);

      // 2) Copiar el MultipartFile directamente a ese nombre nuevo (sin tocar el archivo “viejo”)
      Files.copy(file.getInputStream(), destino, StandardCopyOption.REPLACE_EXISTING);

      // 3) Restaurar usando ese archivo nuevo
      restoreBackup(uniqueName);

    } catch (IOException e) {
      throw new RuntimeException("Error al guardar archivo para importación", e);
    }
  }

  private String runProcess(List<String> command, String successMessage) {
    try {
      ProcessBuilder pb = new ProcessBuilder(command);
      pb.environment().put("PGPASSWORD", postgresConfig.getPassword());
      pb.redirectErrorStream(true);
      Process process = pb.start();

      try (BufferedReader reader =
          new BufferedReader(new InputStreamReader(process.getInputStream()))) {
        String line;
        while ((line = reader.readLine()) != null) {
          System.out.println(line);
        }
      }

      int exitCode = process.waitFor();
      if (exitCode == 0) return successMessage;

      throw new RuntimeException("Error ejecutando proceso: " + String.join(" ", command));
    } catch (Exception e) {
      throw new RuntimeException("Fallo al ejecutar comando de backup", e);
    }
  }
}
