package com.thinhlh.project1.app.cart_item.controller.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class AddItemToCartRequest {
    @NotNull
    @Min(0)
    private Long customerId;

    private List<AddItemToCartItem> items;
}
