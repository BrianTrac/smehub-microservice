package org.example.repository;

import org.example.domain.ProductDomain;
import org.springframework.data.domain.Page;
import java.util.Optional;

public interface IProductRepository {

    Optional<ProductDomain> findById(String id);

    Page<ProductDomain> findAll(String search, int page, int size, String[] sort);

    ProductDomain save(ProductDomain productDomain);
}
