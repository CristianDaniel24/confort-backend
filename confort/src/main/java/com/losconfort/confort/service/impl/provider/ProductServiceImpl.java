package com.losconfort.confort.service.impl.provider;

import com.losconfort.confort.model.provider.ProductModel;
import com.losconfort.confort.repository.provider.ProductRepository;
import com.losconfort.confort.service.provider.ProductService;
import com.losconfort.confortstarterrest.exception.ResourceNotFoundException;
import com.losconfort.confortstarterrest.exception.ShoppingCartException;
import com.losconfort.confortstarterrest.helper.DefaultServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends DefaultServiceImpl<ProductModel, Long, ProductRepository>
    implements ProductService {
  public ProductServiceImpl(ProductRepository repository) {
    super(repository);
  }

  @Override
  public ProductModel findById(Long id) {
    return this.repository
        .findById(id)
        .orElseThrow(() -> new ShoppingCartException("Producto con id " + id + " no encontrado"));
  }

  @Override
  public void updateStock(Long productId, Long newStock) {
    ProductModel product =
        this.repository
            .findById(productId)
            .orElseThrow(() -> new ResourceNotFoundException("No se encontro el producto"));
    product.setStock(newStock);
    this.repository.save(product);
  }
}
