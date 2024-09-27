package com.in28minutes.microservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;


//Circuit breaker allow you to do not cacade problems through microservices
//For instance, if you have a down microservice it will detect it and react to not hurt other microservices
//Check for circuit breaer behaviour on the web
@RestController
public class CircuitBreakerController {
	
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
	//It will retry to access to the requested url
	//@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
	//It will apply the circuit breaker pattern
	//@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
	//You can set a limit number of call to a specific api in app properties
	//@RateLimiter(name="default")
	@Bulkhead(name="sample-api")
	//10s => 10000 calls to the sample api
	public String sampleApi() {
		logger.info("Sample api call received");
//		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", 
//					String.class);
//		return forEntity.getBody();
		return "sample-api";
	}
	
	public String hardcodedResponse(Exception ex) {
		return "fallback-response";
	}
}
