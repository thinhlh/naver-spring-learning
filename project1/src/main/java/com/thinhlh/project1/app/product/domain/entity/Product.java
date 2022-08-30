package com.thinhlh.project1.app.product.domain.entity;

import com.thinhlh.project1.app.cart_item.domain.entity.CartItem;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long id;

    @Column(name = "name_product", nullable = false, length = 100)
    private String name;

    @Column(length = 3)
    private String type;

    @Column(length = 3)
    private String size;

    @Column(nullable = false)
    private Double price;

}
