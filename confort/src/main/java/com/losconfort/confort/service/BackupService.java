package com.losconfort.confort.service;

import com.losconfort.confort.dto.BackupDTO;
import java.io.Serializable;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface BackupService extends Serializable {

  List<BackupDTO> listBackups();

  String createBackup();

  void restoreBackup(String filename);

  void importBackup(MultipartFile file);
}
