package org.example.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Map;

public class CreateProductRequest {
    @NotNull(message = "Product type cannot be null")
    private String type;

    @NotNull(message = "Product name cannot be null")
    private String name;

    @NotNull(message = "Product description cannot be null")
    @Min(0)
    private Double totalPrice;

    private Map<String, Object> data;
}
