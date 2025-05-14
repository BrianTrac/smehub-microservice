package org.example.repo;

import lombok.RequiredArgsConstructor;
import org.example.datasource.repo.IJpaProductRepository;
import org.example.domain.ProductDomain;
import org.example.mapper.IProductEntityMapper;
import org.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductRepository implements IProductRepository {
    private final IJpaProductRepository jpaProductRepository;
    private final IProductEntityMapper productEntityMapper;

    @Override
    public ProductDomain findById(String id) {
        // Implementation to find a product by ID
        return null;
    }

    @Override
    public ProductDomain save(ProductDomain productDomain) {
        // Implementation to save a product
        return null;
    }
}
