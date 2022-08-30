package com.thinhlh.project1.app.product.controller.params;

import lombok.Data;

@Data
public class GetProductsParams {
    private Double price;
    private GetProductCondition condition;
}
