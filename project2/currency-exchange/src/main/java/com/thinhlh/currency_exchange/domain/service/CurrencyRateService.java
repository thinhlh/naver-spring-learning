package com.thinhlh.currency_exchange.domain.service;


import com.thinhlh.currency_exchange.domain.entity.CurrencyRate;

import java.util.List;

public interface CurrencyRateService {
    List<CurrencyRate> getAllCurrencyRate();

    CurrencyRate getCurrencyRate(String from, String to);
}
