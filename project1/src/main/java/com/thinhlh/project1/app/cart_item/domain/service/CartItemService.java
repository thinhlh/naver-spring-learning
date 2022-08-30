package com.thinhlh.project1.app.cart_item.domain.service;

import com.thinhlh.project1.app.cart_item.controller.dto.AddItemToCartRequest;
import com.thinhlh.project1.app.cart_item.controller.dto.CartItemResponse;
import com.thinhlh.project1.app.cart_item.controller.dto.GetCartItemsRequest;
import com.thinhlh.project1.app.cart_item.domain.entity.CartItem;

import java.util.List;

public interface CartItemService {
    Boolean addCartItemToCart(AddItemToCartRequest request);

    List<CartItemResponse> getCartItems(GetCartItemsRequest request);
}
