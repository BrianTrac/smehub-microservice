package org.example.repository;

import org.example.domain.ProductDomain;

public interface IProductRepository {

    ProductDomain findById(String id);

    ProductDomain save(ProductDomain productDomain);
}
