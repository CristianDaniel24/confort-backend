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
  public ProductModel create(ProductModel model) {
    if (this.repository.existsByName(model.getName())) {
      throw new ShoppingCartException("Ya existe un producto registrado con ese nombre");
    }
    if (this.repository.existsByCode(model.getCode())) {
      throw new ShoppingCartException("Ya existe un producto registrado con ese codigo");
    }
    return super.create(model);
  }

  @Override
  public ProductModel update(Long id, ProductModel model) {
    if (this.repository.existsByName(model.getName())) {
      throw new ShoppingCartException("No puedes editar el producto con el mismo nombre");
    }
    if (this.repository.existsByCode(model.getCode())) {
      throw new ShoppingCartException("No puedes editar el producto con el mismo codigo");
    }
    return super.update(id, model);
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

  @Override
  public Long productsStock() {
    return this.repository.getTotalStock();
  }

  @Override
  public ProductModel lowStock() {
    return this.repository.findFirstByStockGreaterThanOrderByStockAsc(0L);
  }
}
