package org.example.service;

import org.example.domain.ProductDomain;

public interface IProductService {

    ProductDomain getProductById(String id);

    ProductDomain createProduct(CreateProductRequest createProductRequest);

}
