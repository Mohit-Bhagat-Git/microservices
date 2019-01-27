package currency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import currency.feign.ForexClient;
import currency.model.ExchangeValue;

@RestController
public class CurrencyController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ForexClient forexTemplate;

	@GetMapping("/aliveCheck")
	public String alivecheck() {
	   //return restTemplate.getForObject("http://forex-service/aliveCheck", String.class);
		return forexTemplate.aliveCheck();
	}
	

	@GetMapping("/getExchangeValue/from/{from}/to/{to}")
	public ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to) {
//		String url = "http://forex-service/getExchangeRate/from/"+from+"/to/"+to;
//		ExchangeValue ref = restTemplate.getForObject(url, ExchangeValue.class);
//		ref.setExchangeRate("75.69");
//		return ref;
		
		ExchangeValue ref = forexTemplate.getExchangeValue(from, to);
		ref.setExchangeRate("75.69");
		return ref;
	}
}
