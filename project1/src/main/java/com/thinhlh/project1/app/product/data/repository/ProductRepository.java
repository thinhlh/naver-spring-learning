package com.thinhlh.project1.app.product.data.repository;

import com.thinhlh.project1.app.product.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByPriceLessThan(Double price);

    List<Product> findAllByPriceGreaterThan(Double price);

    List<Product> findAllByPriceEquals(Double price);
}
