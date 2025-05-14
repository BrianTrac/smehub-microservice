package org.example.validation;

import org.example.domain.ProductDomain;

public interface ProductBusinessValidator {
    void validate(ProductDomain productDomain);
    String getType();
}
