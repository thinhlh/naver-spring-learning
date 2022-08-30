package com.thinhlh.project1.app.cart.domain.entity;

import com.thinhlh.project1.app.cart_item.domain.entity.CartItem;
import com.thinhlh.project1.app.customer.domain.entity.Customer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Cart {
    @Id
    @Column(name = "cart_id")
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "cart")
    private Customer customer;

    @OneToMany(mappedBy = "cart")
    List<CartItem> cartItems;
}
