package com.losconfort.confort.controller.impl.dashboard;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.losconfort.confort.controller.dashboard.DashboardController;
import com.losconfort.confort.dto.MainCardsDTO;
import com.losconfort.confort.dto.RecentActivityDTO;
import com.losconfort.confort.service.dashboard.DashboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class DashboardControllerImpl implements DashboardController {

  private final DashboardService service;

  public DashboardControllerImpl(DashboardService service) {
    this.service = service;
  }

  @Override
  @GetMapping(path = "/mainCards", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<MainCardsDTO> mainCardsResponse() {
    return ResponseEntity.ok(this.service.mainCardsResponse());
  }

  @Override
  @GetMapping(path = "/recentActivity")
  public ResponseEntity<RecentActivityDTO> recentActivityResponse() {
    return ResponseEntity.ok(this.service.recentActivity());
  }
}
