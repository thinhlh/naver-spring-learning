package com.thinhlh.currency_calculation.config;

import com.thinhlh.currency_calculation.domain.entities.CurrencyRate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("CURRENCY-EXCHANGE-SERVICE")
public interface CurrencyCalculationClient {
    @GetMapping("/rate/{from}/{to}")
    CurrencyRate getCurrency(@PathVariable("from") String from, @PathVariable("to") String to);
}
