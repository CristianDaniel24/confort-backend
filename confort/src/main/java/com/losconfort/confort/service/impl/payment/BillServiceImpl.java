package com.losconfort.confort.service.impl.payment;

import com.losconfort.confort.enums.ShoppingCartEnum;
import com.losconfort.confort.model.cart.ShoppingCartModel;
import com.losconfort.confort.model.payment.BillModel;
import com.losconfort.confort.repository.payment.BillRepository;
import com.losconfort.confort.service.cart.ShoppingCartService;
import com.losconfort.confort.service.payment.BillService;
import com.losconfort.confortstarterrest.exception.ResourceNotFoundException;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import java.util.List;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl extends DefaultServiceImpl<BillModel, Long, BillRepository>
    implements BillService {

  private final ShoppingCartService shoppingCartService;

  public BillServiceImpl(BillRepository repository, @Lazy ShoppingCartService shoppingCartService) {
    super(repository);
    this.shoppingCartService = shoppingCartService;
  }

  @Override
  public List<BillModel> getBillByPersonId(Long personId) {
    return this.repository.findAllByPersonId(personId);
  }

  @Override
  public BillModel confirmOrder(Long orderId) {
    BillModel bill =
        this.repository
            .findById(orderId)
            .orElseThrow(
                () ->
                    new ResourceNotFoundException(
                        "Ocurrio un error al intentar encontrar el pedido"));

    ShoppingCartModel shoppingCart =
        this.shoppingCartService.getShoppingCartId(bill.getShoppingCart().getId());
    shoppingCart.setStatus(ShoppingCartEnum.PAGADO);
    bill.setShoppingCart(shoppingCart);
    this.repository.save(bill);
    return bill;
  }

  @Override
  public BillModel cancelOrder(Long orderId) {
    BillModel bill =
        this.repository
            .findById(orderId)
            .orElseThrow(
                () ->
                    new ResourceNotFoundException(
                        "Ocurrio un error al intentar encontrar el pedido"));

    ShoppingCartModel shoppingCart =
        this.shoppingCartService.getShoppingCartId(bill.getShoppingCart().getId());
    shoppingCart.setStatus(ShoppingCartEnum.CANCELADO);
    bill.setShoppingCart(shoppingCart);
    this.repository.save(bill);
    return bill;
  }
}
