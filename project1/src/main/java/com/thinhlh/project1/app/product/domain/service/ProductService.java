package com.thinhlh.project1.app.product.domain.service;


import com.thinhlh.project1.app.product.controller.params.GetProductsParams;
import com.thinhlh.project1.app.product.domain.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts(GetProductsParams params);

    Product getProductById(Long productId);
}
