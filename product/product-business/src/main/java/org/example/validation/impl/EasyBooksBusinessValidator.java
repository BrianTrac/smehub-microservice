package org.example.validation.impl;

import org.example.domain.ProductDomain;
import org.example.validation.ProductBusinessValidator;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EasyBooksBusinessValidator implements ProductBusinessValidator {
    @Override
    public void validate(ProductDomain productDomain) {
        Map<String, Object> data = productDomain.getData();

        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Data cannot be null or empty");

        }

        int numberOfMonthsUsed = (int) data.getOrDefault("number_of_months_used", 0);
        int numberOfDocuments = (int) data.getOrDefault("number_of_documents", 0);

        if (numberOfMonthsUsed <= 0) {
            throw new IllegalArgumentException("Number of months used must be greater than 0");
        }

        if (numberOfDocuments <= 0) {
            throw new IllegalArgumentException("Number of documents must be greater than 0");
        }

        if (numberOfMonthsUsed > 36) {
            throw new IllegalArgumentException("Number of months used cannot exceed 36");
        }

        if (numberOfDocuments > 100000) {
            throw new IllegalArgumentException("Number of documents cannot exceed 100000");
        }

        if (numberOfMonthsUsed > 20 && numberOfDocuments > 50000) {
            throw new IllegalArgumentException("For more than 20 months, the number of documents cannot exceed 50000");
        }

        // Additional validation logic can be added here
    }

    @Override
    public String getType() {
        return "EasyBooks";
    }
}
