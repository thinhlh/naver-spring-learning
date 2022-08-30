package com.thinhlh.project1.app.customer.domain.entity;

import com.thinhlh.project1.app.cart.domain.entity.Cart;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "customer_name", nullable = false)
    private String name;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "phone_no", nullable = false, length = 20)
    private String phone;

    @OneToOne()
    @JoinColumn(name = "cart_id")
    private Cart cart;
}
