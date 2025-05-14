package org.example.validation.impl;

import org.example.domain.ProductDomain;
import org.example.validation.ProductBusinessValidator;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class VietTelOfficeBusinessValidator implements ProductBusinessValidator {
    @Override
    public void validate(ProductDomain productDomain) {
        Map<String, Object> data = productDomain.getData();

        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Data cannot be null or empty");
        }

        int numberOfUsers = (int) data.getOrDefault("number_of_users", 0);
        int numberOfMonthsUsed = (int) data.getOrDefault("number_of_months_used", 0);
        Double totalPrice = productDomain.getTotalPrice();

        if (numberOfUsers <= 0) {
            throw new IllegalArgumentException("Number of users must be greater than 0");
        }

        if (numberOfMonthsUsed <= 0) {
            throw new IllegalArgumentException("Number of months used must be greater than 0");
        }

        if (numberOfUsers > 100) {
            throw new IllegalArgumentException("Number of users cannot exceed 100");
        }

        if (numberOfMonthsUsed > 12) {
            throw new IllegalArgumentException("Number of months used cannot exceed 12");
        }

        if (numberOfUsers > 50 && numberOfMonthsUsed > 6) {
            throw new IllegalArgumentException("For more than 50 users, the number of months used cannot exceed 6");
        }

        if (totalPrice == null || totalPrice <= 0) {
            throw new IllegalArgumentException("Total price must be greater than 0");
        }

        // Additional validation logic can be added here
    }

    @Override
    public String getType() {
        return "VietTelOffice";
    }
}
