package org.example.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Map;

public class UpdateProductRequest {
    private String type;

    private String name;

    @Min(0)
    private Double totalPrice;

    private Map<String, Object> data;
}
