package currency_calculation.config;

import currency_calculation.models.CurrencyRate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@FeignClient("CURRENCY-EXCHANGE-SERVICE")
public interface CurrencyCalculationClient {
    @GetMapping("/rate/{from}/{to}")
    CurrencyRate getCurrency(@PathVariable("from") String from, @PathVariable("to") String to);
}
