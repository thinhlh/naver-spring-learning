package com.thinhlh.project1.app.cart_item.controller;

import com.thinhlh.project1.app.cart.domain.service.CartService;
import com.thinhlh.project1.app.cart_item.controller.dto.AddItemToCartRequest;
import com.thinhlh.project1.app.cart_item.controller.dto.CartItemResponse;
import com.thinhlh.project1.app.cart_item.controller.dto.GetCartItemsRequest;
import com.thinhlh.project1.app.cart_item.domain.entity.CartItem;
import com.thinhlh.project1.app.cart_item.domain.service.CartItemService;
import com.thinhlh.project1.base.BaseController;
import com.thinhlh.project1.base.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CartItemController extends BaseController {
    private final CartItemService cartItemService;

    @PostMapping("/cart/add-item")
    private ResponseEntity<BaseResponse<Boolean>> addItemToCart(@RequestBody() @Valid() AddItemToCartRequest request) {
        return successResponse(cartItemService.addCartItemToCart(request));
    }

    @GetMapping("/cart-item")
    private ResponseEntity<BaseResponse<List<CartItemResponse>>> getCartItem(GetCartItemsRequest request) {
        return successResponse(cartItemService.getCartItems(request));
    }
}
