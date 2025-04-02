package com.losconfort.confort.service.impl.provider;

import com.losconfort.confort.model.provider.TypeProductModel;
import com.losconfort.confort.repository.provider.TypeProductRepository;
import com.losconfort.confort.service.provider.TypeProductService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TypeProductServiceImpl
    extends DefaultServiceImpl<TypeProductModel, Long, TypeProductRepository>
    implements TypeProductService {
  public TypeProductServiceImpl(TypeProductRepository repository) {
    super(repository);
  }
}
