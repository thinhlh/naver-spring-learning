package com.thinhlh.currency_exchange.data.repositories;

import com.thinhlh.currency_exchange.domain.entity.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, Long> {
    CurrencyRate getByFromAndTo(String from, String to);
}
