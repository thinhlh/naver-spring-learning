package com.thinhlh.currency_calculation.domain.services;

import com.thinhlh.currency_calculation.domain.entities.CalculatedAmount;

public interface CurrencyCalculationService {
    CalculatedAmount exchange(String from, String to, Double amount);
}
