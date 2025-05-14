package org.example.service;

import org.example.domain.ProductDomain;
import org.springframework.data.domain.Page;

public interface IProductService {

    ProductDomain getProductById(String id);

    Page<ProductDomain> getAllProducts(String search, int page, int size, String[] sort);

    ProductDomain createProduct(ProductDomain productDomain);
}

