package org.example.validation.impl;

import org.example.validation.ProductBusinessValidator;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class ProductValidatorRegistry {
    private final Map<String, ProductBusinessValidator> validatorMap = new HashMap<>();

    public ProductValidatorRegistry(List<ProductBusinessValidator> validators) {
        for (ProductBusinessValidator validator : validators) {
            String validatorName = validator.getType();
            validatorMap.put(validatorName, validator);
        }
    }

    public Optional<ProductBusinessValidator> getValidator(String type) {
        return Optional.ofNullable(validatorMap.get(type));
    }
}
