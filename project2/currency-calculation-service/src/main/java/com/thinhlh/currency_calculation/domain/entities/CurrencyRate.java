package com.thinhlh.currency_calculation.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyRate {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private int port;
}
