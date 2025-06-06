package com.losconfort.confort.controller;

import com.losconfort.confort.dto.BackupDTO;
import java.io.Serializable;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface BackupController extends Serializable {

  ResponseEntity<List<BackupDTO>> listBackups();

  ResponseEntity<String> createBackup();

  ResponseEntity<String> restoreBackup(String filename);

  ResponseEntity<String> importBackup(MultipartFile file);
}
