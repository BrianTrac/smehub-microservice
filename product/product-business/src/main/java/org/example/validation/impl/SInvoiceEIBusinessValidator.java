package org.example.validation.impl;

import org.example.domain.ProductDomain;
import org.example.validation.ProductBusinessValidator;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SInvoiceEIBusinessValidator implements ProductBusinessValidator {
    @Override
    public void validate(ProductDomain productDomain) {

        Map<String, Object> data = productDomain.getData();

        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Data cannot be null or empty");

        }

        int numberOfMonthsUsed = (int) data.getOrDefault("number_of_months_used", 0);
        int numberOfInvoices = (int) data.getOrDefault("number_of_invoices", 0);
        Double invoiceFee = (Double) data.getOrDefault("invoice_fee", 0.0);
        Double totalPrice = productDomain.getTotalPrice();

        if (numberOfMonthsUsed <= 0) {
            throw new IllegalArgumentException("Number of months used must be greater than 0");
        }

        if (numberOfInvoices <= 0) {
            throw new IllegalArgumentException("Number of invoices must be greater than 0");
        }

        if (numberOfMonthsUsed > 36) {
            throw new IllegalArgumentException("Number of months used cannot exceed 36");
        }

        if (numberOfInvoices > 100000) {
            throw new IllegalArgumentException("Number of invoices cannot exceed 100000");
        }

        if (numberOfMonthsUsed > 20 && numberOfInvoices > 50000) {
            throw new IllegalArgumentException("For more than 20 months, the number of invoices cannot exceed 50000");
        }

        if (invoiceFee == null || invoiceFee <= 0) {
            throw new IllegalArgumentException("Invoice fee must be greater than 0");
        }

        if (totalPrice == null || totalPrice <= 0) {
            throw new IllegalArgumentException("Total price must be greater than 0");
        }

        if (totalPrice < invoiceFee) {
            throw new IllegalArgumentException("Total price cannot be less than invoice fee");
        }

        // Additional validation logic can be added here
    }

    @Override
    public String getType() {
        return "SInvoiceEI";
    }
}
