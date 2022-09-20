package com.thinhlh.currency_exchange.controllers;

import com.thinhlh.currency_exchange.base.BaseController;
import com.thinhlh.currency_exchange.base.BaseResponse;
import com.thinhlh.currency_exchange.domain.entity.CurrencyRate;
import com.thinhlh.currency_exchange.domain.service.CurrencyRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CurrencyRateController extends BaseController {
    private final CurrencyRateService currencyRateService;

    @Autowired
    private final Environment environment;

    @GetMapping("/rates")
    private ResponseEntity<BaseResponse<List<CurrencyRate>>> getCurrencyRateList() {
        return successResponse(currencyRateService.getAllCurrencyRate());
    }

    @GetMapping("/rate/{from}/{to}")
    private CurrencyRate getCurrencyRate(@PathVariable("from") String from, @PathVariable("to") String to) {
        var res = currencyRateService.getCurrencyRate(from, to);

        res.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

        return res;
    }
}
