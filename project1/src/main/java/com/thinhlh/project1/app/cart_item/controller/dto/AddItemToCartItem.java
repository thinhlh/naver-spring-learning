package com.thinhlh.project1.app.cart_item.controller.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class AddItemToCartItem {
    @NotNull
    @Min(0)
    private Long productId;

    @NotNull
    @Min(0)
    private Long quantity;
}
