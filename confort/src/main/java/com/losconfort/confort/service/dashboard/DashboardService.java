package com.losconfort.confort.service.dashboard;

import com.losconfort.confort.dto.MainCardsDTO;
import com.losconfort.confort.dto.RecentActivityDTO;

public interface DashboardService {

  MainCardsDTO mainCardsResponse();

  RecentActivityDTO recentActivity();
}
