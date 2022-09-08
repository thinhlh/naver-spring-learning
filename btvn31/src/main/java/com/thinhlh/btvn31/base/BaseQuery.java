package com.thinhlh.btvn31.base;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class BaseQuery {
    @Min(0)
    private Long offset;
    @Min(0)
    private Long limit;
}
