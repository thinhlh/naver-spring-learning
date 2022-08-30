package com.thinhlh.project1.app.cart_item.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class CartItemResponse {
    private Long cartId;
    private Long productId;
    private Long quantity;

    @JsonFormat(pattern = "HH:mm:ss dd-MM-yyyy")
    private Date dateAdded;

    private BigDecimal totalAmount;
}
