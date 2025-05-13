package org.example.datasource.repo;

import org.example.datasource.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJpaProductRepository extends JpaRepository<ProductEntity, String> {
    // Custom query methods can be defined here if needed
}
