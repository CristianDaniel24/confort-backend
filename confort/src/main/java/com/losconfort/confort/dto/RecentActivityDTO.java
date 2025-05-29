package com.losconfort.confort.dto;

import com.losconfort.confort.model.ClientModel;
import com.losconfort.confort.model.payment.BillModel;
import com.losconfort.confort.model.procedure.ServiceModel;
import com.losconfort.confort.model.provider.ProductModel;
import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecentActivityDTO implements Serializable {

  @Serial private static final long serialVersionUID = -4464018833840153324L;

  private ServiceModel newService;

  private ProductModel lowStock;

  private BillModel billPaid;

  private ClientModel newClient;
}
