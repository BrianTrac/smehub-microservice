package org.example.repo;

import lombok.RequiredArgsConstructor;
import org.example.datasource.entity.ProductEntity;
import org.example.datasource.repo.IJpaProductRepository;
import org.example.domain.ProductDomain;
import org.example.mapper.IProductEntityMapper;
import org.example.repository.IProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import vn.test.hub.core.utils.SearchingUtils;
import vn.test.hub.core.utils.SortingUtils;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepository implements IProductRepository {
    private final IJpaProductRepository jpaProductRepository;
    private final IProductEntityMapper productEntityMapper;

    @Override
    public Optional<ProductDomain> findById(String id) {
        return jpaProductRepository.findById(id)
                .map(productEntityMapper::toDomain);
    }

    @Override
    public Page<ProductDomain> findAll(String search, int page, int size, String[] sort) {
        Sort sortObj = SortingUtils.convertToSort(sort);
        Pageable pageable = PageRequest.of(page, size, sortObj);
        Specification<ProductEntity> specification = (Specification<ProductEntity>) SearchingUtils.buildSpecification(search);

        return jpaProductRepository.findAll(specification, pageable)
                .map(productEntityMapper::toDomain);
    }

    @Override
    public ProductDomain save(ProductDomain productDomain) {
        ProductEntity productEntity = productEntityMapper.toEntity(productDomain);
        ProductEntity savedProductEntity = jpaProductRepository.save(productEntity);
        return productEntityMapper.toDomain(savedProductEntity);
    }
}
