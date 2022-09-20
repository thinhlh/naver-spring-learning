package currency_calculation.controllers;

import currency_calculation.base.BaseController;
import currency_calculation.base.BaseResponse;
import currency_calculation.config.CurrencyCalculationClient;
import currency_calculation.models.CalculatedAmount;
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
    private final CurrencyCalculationClient currencyCalculationClient;

    private final RestTemplate restTemplate;

    @GetMapping("/exchange")
    public ResponseEntity<BaseResponse<CalculatedAmount>> getConversion(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("amount") Double amount) {
        var result = currencyCalculationClient.getCurrency(from, to);

        var res = new CalculatedAmount();

        res.setId(result.getId());
        res.setFrom(result.getFrom());
        res.setTo(result.getTo());
        res.setQuantity(BigDecimal.valueOf(amount));
        res.setConversionMultiple(result.getConversionMultiple());
        res.setTotalCalculatedAmount(BigDecimal.valueOf(amount * result.getConversionMultiple().doubleValue()));
        res.setPort(result.getPort());
        return successResponse(res);
    }
}
