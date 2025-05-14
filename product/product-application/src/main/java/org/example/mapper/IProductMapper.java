package org.example.mapper;

import org.example.domain.ProductDomain;
import org.example.dto.request.CreateProductRequest;
import org.example.dto.response.CreateProductResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProductMapper {
    public ProductDomain toDomain(CreateProductRequest createProductRequest);
    public CreateProductResponse toCreateProductResponse(ProductDomain productDomain);
}
