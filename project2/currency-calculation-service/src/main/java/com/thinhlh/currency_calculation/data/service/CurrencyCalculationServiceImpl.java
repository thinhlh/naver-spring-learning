package com.thinhlh.currency_calculation.data.service;

import com.thinhlh.currency_calculation.config.CurrencyCalculationClient;
import com.thinhlh.currency_calculation.domain.entities.CalculatedAmount;
import com.thinhlh.currency_calculation.domain.services.CurrencyCalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CurrencyCalculationServiceImpl implements CurrencyCalculationService {
    private final CurrencyCalculationClient currencyCalculationClient;


    @Override
    public CalculatedAmount exchange(String from, String to, Double amount) {
        var exchangeRate = currencyCalculationClient.getCurrency(from, to);
        return CalculatedAmount
                .builder()
                .id(exchangeRate.getId())
                .from(from)
                .to(to)
                .conversionMultiple(exchangeRate.getConversionMultiple())
                .port(exchangeRate.getPort())
                .totalCalculatedAmount(BigDecimal.valueOf(amount * exchangeRate.getConversionMultiple().doubleValue()))
                .quantity(BigDecimal.valueOf(amount))
                .build();
    }
}
