package org.example.datasource.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import vn.test.hub.core.entity.BaseEntity;

import java.util.Map;

@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity {
    private String type;
    private String name;
    private Double totalPrice;
    private Map<String, Object> data;
}
