package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.ProductDomain;
import org.example.repository.IProductRepository;
import org.example.service.IProductService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
    private final IProductRepository productRepository;

    @Override
    public ProductDomain getProductById(String id) {
        // Implementation to get a product by ID
        return null;
    }

    @Override
    public ProductDomain createProduct(CreateProductRequest createProductRequest) {
        // Implementation to create a new product
        return null;
    }
}
