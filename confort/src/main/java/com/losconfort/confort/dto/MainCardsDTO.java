package com.losconfort.confort.dto;

import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MainCardsDTO implements Serializable {

  @Serial private static final long serialVersionUID = -5455792633431812001L;

  private Double monthlyIncome;

  private Long pendingOrders;

  private Long totalClients;

  private Long productsStock;
}
