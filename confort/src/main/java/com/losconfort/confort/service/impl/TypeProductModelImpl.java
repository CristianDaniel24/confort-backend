package com.losconfort.confort.service.impl;

import com.losconfort.confort.model.TypeProductModel;
import com.losconfort.confort.repository.TypeProductRepository;
import com.losconfort.confort.service.TypeProductService;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TypeProductModelImpl
    extends DefaultServiceImpl<TypeProductModel, Long, TypeProductRepository>
    implements TypeProductService {
  public TypeProductModelImpl(TypeProductRepository repository) {
    super(repository);
  }
}
