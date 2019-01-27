package currency.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import currency.model.ExchangeValue;

@FeignClient("forex-service")
public interface ForexClient {

	@GetMapping("/getExchangeRate/from/{from}/to/{to}")
	ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to);
	
	@GetMapping("/aliveCheck")
	String aliveCheck();
}
