package com.thinhlh.project1.app.product.controller;

import com.thinhlh.project1.app.product.controller.params.GetProductsParams;
import com.thinhlh.project1.app.product.domain.entity.Product;
import com.thinhlh.project1.app.product.domain.service.ProductService;
import com.thinhlh.project1.base.BaseController;
import com.thinhlh.project1.base.BaseResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController extends BaseController {
    private final ProductService productService;

    @GetMapping("/products")
    private ResponseEntity<BaseResponse<List<Product>>> getProducts(GetProductsParams params) {
        return successResponse(productService.getProducts(params));
    }
}
