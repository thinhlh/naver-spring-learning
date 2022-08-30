package com.thinhlh.project1.app.cart_item.controller.dto;

import com.thinhlh.project1.base.BaseQuery;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetCartItemsRequest extends BaseQuery {
    private Long customerId;
    private String productName;
}
