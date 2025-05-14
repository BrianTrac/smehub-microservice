package org.example.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.ProductDomain;
import org.example.exception.ProductExistsException;
import org.example.exception.ProductNotFoundException;
import org.example.repository.IProductRepository;
import org.example.service.IProductService;
import org.example.validation.ProductJsonSchemaValidator;
import org.example.validation.impl.ProductValidatorRegistry;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements IProductService {
    private final IProductRepository productRepository;
    private final ProductJsonSchemaValidator jsonSchemaValidator;
    private final ProductValidatorRegistry validatorRegistry;

    @Override
    public ProductDomain getProductById(String id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    @Override
    public Page<ProductDomain> getAllProducts(String search, int page, int size, String[] sort) {
        return productRepository.findAll(search, page, size, sort);
    }

    @Override
    @Transactional
    public ProductDomain createProduct(ProductDomain productDomain) {
        // Check if product already exists
        if (productRepository.findById(productDomain.getId()).isPresent()) {
            log.error("Product already exists with id: {}", productDomain.getId());
            throw new ProductExistsException("Product already exists with id: " + productDomain.getId());
        }


        log.debug("Validating product data for product with id: {}", productDomain.getId());
        // Validate dynamic data via JSON Schema
        jsonSchemaValidator.validate(productDomain.getData(), productDomain.getType());

        log.debug("Applying business validation rules for product with id: {}", productDomain.getId());
        // Apply business validation rules
        validatorRegistry.getValidator(productDomain.getType())
                .ifPresent(validator -> {
                    log.debug("Executing validator for product type: {}", productDomain.getType());
                    validator.validate(productDomain);
                });

        log.info("Saving product with id: {}", productDomain.getId());
        // Save the product
        ProductDomain savedProduct = productRepository.save(productDomain);

        log.info("Product successfully created with id: {}", savedProduct.getId());
        return savedProduct;
    }
}
