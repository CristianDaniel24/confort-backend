package com.losconfort.confort.controller.impl;

import com.losconfort.confort.controller.BackupController;
import com.losconfort.confort.dto.BackupDTO;
import com.losconfort.confort.service.BackupService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/backup")
public class BackupControllerImpl implements BackupController {

  private final BackupService backupService;

  public BackupControllerImpl(BackupService backupService) {
    this.backupService = backupService;
  }

  @Override
  @GetMapping("/list")
  public ResponseEntity<List<BackupDTO>> listBackups() {
    return ResponseEntity.ok(backupService.listBackups());
  }

  @Override
  @PostMapping("/create")
  public ResponseEntity<String> createBackup() {
    String result = backupService.createBackup();
    return ResponseEntity.ok(result);
  }

  @Override
  @PostMapping("/restore")
  public ResponseEntity<String> restoreBackup(@RequestParam("filename") String filename) {
    System.out.println("Restaurando backup: " + filename);
    backupService.restoreBackup(filename);
    return ResponseEntity.ok("Restauración completada");
  }

  @Override
  @PostMapping("/import")
  public ResponseEntity<String> importBackup(@RequestParam("file") MultipartFile file) {
    backupService.importBackup(file);
    return ResponseEntity.ok("Importacion completada");
  }
}
