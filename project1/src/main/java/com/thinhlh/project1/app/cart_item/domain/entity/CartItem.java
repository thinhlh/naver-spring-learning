package com.thinhlh.project1.app.cart_item.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thinhlh.project1.app.cart.domain.entity.Cart;
import com.thinhlh.project1.app.product.domain.entity.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
public class CartItem {
    @EmbeddedId
    private CartItemKey id;

    @ManyToOne(optional = false)
    @MapsId("cart_id")
    @JoinColumn(name = "cart_id")
    @JsonIgnore
    private Cart cart;

    @ManyToOne(optional = false)
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity_wished", nullable = false)
    private Long quantityWished;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "HH:mm:ss dd-MM-yyyy")
    @Column(name = "date_added", nullable = false)
    private Date dateAdded;

    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;
}
