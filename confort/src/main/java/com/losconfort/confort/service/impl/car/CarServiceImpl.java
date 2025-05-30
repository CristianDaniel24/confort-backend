package com.losconfort.confort.service.impl.car;

import com.losconfort.confort.model.ClientModel;
import com.losconfort.confort.model.car.CarModel;
import com.losconfort.confort.repository.car.CarRepository;
import com.losconfort.confort.service.ClientService;
import com.losconfort.confort.service.car.CarService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl extends DefaultServiceImpl<CarModel, Long, CarRepository>
    implements CarService {

  private final ClientService clientService;

  public CarServiceImpl(CarRepository repository, ClientService clientService) {
    super(repository);
    this.clientService = clientService;
  }

  @Override
  public List<CarModel> getCarByPersonId(Long personId) {
    return this.repository.findAllByPersonId(personId);
  }

  @Override
  public CarModel create(CarModel model) {
    ClientModel client = this.clientService.findPersonId(model.getClient().getPerson().getId());
    model.setClient(client);
    return super.create(model);
  }
}
