package org.example.dto.response;

import java.time.Instant;
import java.util.Map;

public class CreateProductResponse {
    private String id;
    private String type;
    private String name;
    private Double totalPrice;
    private Map<String, Object> data;
    private Instant createdAt;
    private Instant updatedAt;
    private String createdBy;
    private String updatedBy;
    private Boolean deleted;
}
