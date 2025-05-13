package org.example.dto.request;

import java.util.Map;

public class CreateProductRequest {
    private String type;
    private String name;
    private Double totalPrice;
    private Map<String, Object> data;
}
