package com.thinhlh.currency_exchange.data.services;

import com.thinhlh.currency_exchange.data.repositories.CurrencyRateRepository;
import com.thinhlh.currency_exchange.domain.entity.CurrencyRate;
import com.thinhlh.currency_exchange.domain.service.CurrencyRateService;
import com.thinhlh.currency_exchange.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyRateServiceImpl implements CurrencyRateService {

    private final CurrencyRateRepository currencyRateRepository;

    @Override
    public List<CurrencyRate> getAllCurrencyRate() {
        return currencyRateRepository.findAll();
    }

    @Override
    public CurrencyRate getCurrencyRate(String from, String to) {
        var result = currencyRateRepository.getByFromAndTo(from, to);
        if (result == null) {
            throw new NotFoundException("Currency Rate Conversion Not Found");
        } else {
            return result;
        }
    }
}
