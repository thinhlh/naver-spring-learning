package com.thinhlh.currency_calculation.controllers;

import com.thinhlh.currency_calculation.base.BaseController;
import com.thinhlh.currency_calculation.base.BaseResponse;
import com.thinhlh.currency_calculation.config.CurrencyCalculationClient;
import com.thinhlh.currency_calculation.domain.entities.CalculatedAmount;
import com.thinhlh.currency_calculation.domain.services.CurrencyCalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Controller
public class CurrencyCalculationController extends BaseController {

    private final RestTemplate restTemplate;

    private final CurrencyCalculationService currencyCalculationService;

    @GetMapping("/exchange")
    public ResponseEntity<BaseResponse<CalculatedAmount>> getConversion(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("amount") Double amount) {
        return successResponse(currencyCalculationService.exchange(from, to, amount));
    }
}
