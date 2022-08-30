package com.thinhlh.project1.app.cart.domain.service;

import com.thinhlh.project1.app.cart.domain.entity.Cart;
import com.thinhlh.project1.app.cart_item.controller.dto.AddItemToCartRequest;

public interface CartService {
    Cart findByCustomerId(Long customerId);
}
