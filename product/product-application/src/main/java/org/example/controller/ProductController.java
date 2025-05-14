package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.ProductDomain;
import org.example.dto.request.CreateProductRequest;
import org.example.dto.response.CreateProductResponse;
import org.example.exception.ProductExistsException;
import org.example.exception.ProductNotFoundException;
import org.example.mapper.IProductMapper;
import org.example.service.IProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.test.hub.core.info.PaginationInfo;
import vn.test.hub.core.response.BaseResponse;
import vn.test.hub.core.utils.ResponseUtils;
import vn.test.hub.core.utils.SearchingUtils;
import vn.test.hub.core.utils.SortingUtils;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;
    private final IProductMapper productMapper;

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<CreateProductResponse, Void>> getProductById(@PathVariable String id) {
        try {
            ProductDomain productDomain = productService.getProductById(id);
            CreateProductResponse response = productMapper.toCreateProductResponse(productDomain);
            return ResponseUtils.success(response);
        }
        catch (ProductNotFoundException e) {
            return ResponseUtils.error(e.getMessage(), e.getHttpStatus());
        }
        catch (Exception e) {
            return ResponseUtils.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<BaseResponse<List<CreateProductResponse>, PaginationInfo>> getAllProducts(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "id,asc") String[] sort,
            @RequestParam(value = "search", required = false) String search
    ) {
        try {
            Page<ProductDomain> productPage = productService.getAllProducts(search, page, size, sort);
            List<CreateProductResponse> productResponses = productMapper.toCreateProductResponseList(productPage.getContent());

            return ResponseUtils.success(
                    productResponses,
                    PaginationInfo.of(productPage)
            );
        }
        catch (Exception e) {
            return ResponseUtils.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<BaseResponse<CreateProductResponse, Void>> createProduct(@RequestBody CreateProductRequest productRequest) {
        try {
            ProductDomain productDomain = productMapper.toDomain(productRequest);
            ProductDomain createdProduct = productService.createProduct(productDomain);
            CreateProductResponse response = productMapper.toCreateProductResponse(createdProduct);
            return ResponseUtils.success(response);
        }
        catch (ProductExistsException e) {
            return ResponseUtils.error(e.getMessage(), e.getHttpStatus());
        }
        catch (Exception e) {
            return ResponseUtils.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
