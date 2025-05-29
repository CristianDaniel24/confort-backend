package com.losconfort.confort.service.impl.dashboard;

import com.losconfort.confort.dto.MainCardsDTO;
import com.losconfort.confort.dto.RecentActivityDTO;
import com.losconfort.confort.model.ClientModel;
import com.losconfort.confort.model.payment.BillModel;
import com.losconfort.confort.model.procedure.ServiceModel;
import com.losconfort.confort.model.provider.ProductModel;
import com.losconfort.confort.service.ClientService;
import com.losconfort.confort.service.dashboard.DashboardService;
import com.losconfort.confort.service.payment.BillService;
import com.losconfort.confort.service.procedure.ServiceService;
import com.losconfort.confort.service.provider.ProductService;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {

  private final ClientService clientService;
  private final ProductService productService;
  private final ServiceService serviceService;
  private final BillService billService;

  public DashboardServiceImpl(
      ClientService clientService,
      ProductService productService,
      ServiceService serviceService,
      BillService billService) {
    this.clientService = clientService;
    this.productService = productService;
    this.serviceService = serviceService;
    this.billService = billService;
  }

  @Override
  public MainCardsDTO mainCardsResponse() {
    MainCardsDTO mainCardsDTO = new MainCardsDTO();
    Double totalSumMonth = this.billService.totalSumMonth();
    mainCardsDTO.setMonthlyIncome(totalSumMonth);

    Long pendingOrders = this.serviceService.pendingOrders();
    mainCardsDTO.setPendingOrders(pendingOrders);

    Long totalClients = this.clientService.totalClients();
    mainCardsDTO.setTotalClients(totalClients);

    Long productsStock = this.productService.productsStock();
    mainCardsDTO.setProductsStock(productsStock);
    return mainCardsDTO;
  }

  @Override
  public RecentActivityDTO recentActivity() {
    RecentActivityDTO recentActivityDTO = new RecentActivityDTO();
    ServiceModel newService = this.serviceService.newService();
    recentActivityDTO.setNewService(newService);

    ProductModel lowStock = this.productService.lowStock();
    recentActivityDTO.setLowStock(lowStock);

    BillModel billPaid = this.billService.billPaid();
    recentActivityDTO.setBillPaid(billPaid);

    ClientModel newClient = this.clientService.newClient();
    recentActivityDTO.setNewClient(newClient);
    return recentActivityDTO;
  }
}
