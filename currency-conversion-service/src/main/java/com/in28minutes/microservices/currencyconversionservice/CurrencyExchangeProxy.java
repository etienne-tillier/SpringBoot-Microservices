package com.in28minutes.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange", url="localhost:8000")
//Use to acces to other services with name that correspond
@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {

	//All the data fetched in currency exchange are mapped into CurrencyConvertion object for all fields in common
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	CurrencyConversion retrieveExchangeValue(@PathVariable String from,
			@PathVariable String to);

}
