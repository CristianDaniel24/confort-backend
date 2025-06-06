package com.losconfort.confort.repository.provider;

import com.losconfort.confort.model.provider.ProductModel;
import com.losconfort.confortstarterrest.helper.DefaultRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends DefaultRepository<ProductModel, Long> {

  @Query("SELECT COALESCE(SUM(p.stock), 0) FROM ProductModel p")
  Long getTotalStock();

  ProductModel findFirstByStockGreaterThanOrderByStockAsc(Long stock);

  boolean existsByName(String name);

  boolean existsByCode(String code);
}
