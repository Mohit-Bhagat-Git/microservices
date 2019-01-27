package forexService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import forexService.model.ForexExchange;

@RestController
public class ForexController {
	
	@Autowired
	private Environment env;

	@GetMapping("/getExchangeRate/from/{from}/to/{to}")
	public ForexExchange getExchangeRate(@PathVariable String from, @PathVariable String to) {
		
		ForexExchange ref = new ForexExchange();
		ref.setFrom(from);
		ref.setTo(to);
		ref.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		
		return ref;
	}
	
	@GetMapping("/aliveCheck")
	public String aliveCheck() {
		return "forex-service is alive running on "+env.getProperty("local.server.port");
	}

}
