package org.example.mapper;

import org.example.dto.request.CreateProductRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProductMapper {
    public ProductDomain toDomain(CreateProductRequest createProductRequest);
}
