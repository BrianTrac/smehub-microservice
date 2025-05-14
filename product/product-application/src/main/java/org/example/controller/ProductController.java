package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.ProductDomain;
import org.example.dto.response.CreateProductResponse;
import org.example.exception.ProductNotFoundException;
import org.example.mapper.IProductMapper;
import org.example.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.test.hub.core.info.PaginationInfo;
import vn.test.hub.core.response.BaseResponse;
import vn.test.hub.core.utils.ResponseUtils;

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
}
