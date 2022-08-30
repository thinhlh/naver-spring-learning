package com.thinhlh.project1.app.customer.domain.service;


import com.thinhlh.project1.app.cart.domain.entity.Cart;
import com.thinhlh.project1.app.customer.domain.entity.Customer;

public interface CustomerService {
    Customer getCustomerById(Long customerId);

    Cart getCartByCustomerId(Long customerId);
}
