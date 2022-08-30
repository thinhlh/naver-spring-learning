package com.thinhlh.project1.app.product.data.service;

import com.thinhlh.project1.app.product.controller.params.GetProductsParams;
import com.thinhlh.project1.app.product.data.repository.ProductMybasticRepository;
import com.thinhlh.project1.app.product.data.repository.ProductRepository;
import com.thinhlh.project1.app.product.domain.entity.Product;
import com.thinhlh.project1.app.product.domain.service.ProductService;
import com.thinhlh.project1.config.constants.MessageConstants;
import com.thinhlh.project1.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Resource
    private final ProductMybasticRepository productMybasticRepository;
    private final ProductRepository productRepository;

    @Override
    public List<Product> getProducts(GetProductsParams params) {
        return switch (params.getCondition()) {
            case LESS_THAN -> productMybasticRepository.findAllByPriceLessThan(params.getPrice());
            case GREATER_THAN -> productMybasticRepository.findAllByPriceGreaterThan(params.getPrice());
            case EQUAL -> productMybasticRepository.findAllByPriceEquals(params.getPrice());
        };
    }

    @Override
    public Product getProductById(Long productId) {
        var productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            return productOptional.get();
        } else {
            throw new NotFoundException(MessageConstants.PRODUCT_NOT_FOUND);
        }
    }
}
