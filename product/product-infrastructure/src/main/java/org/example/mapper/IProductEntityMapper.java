package org.example.mapper;

import org.example.datasource.entity.ProductEntity;
import org.example.domain.ProductDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProductEntityMapper {
    public ProductDomain toDomain(ProductEntity productEntity);
    public ProductEntity toEntity(ProductDomain productDomain);
}
