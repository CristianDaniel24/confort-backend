package com.losconfort.confort.controller.dashboard;

import com.losconfort.confort.dto.MainCardsDTO;
import com.losconfort.confort.dto.RecentActivityDTO;
import org.springframework.http.ResponseEntity;

public interface DashboardController {

  ResponseEntity<MainCardsDTO> mainCardsResponse();

  ResponseEntity<RecentActivityDTO> recentActivityResponse();
}
