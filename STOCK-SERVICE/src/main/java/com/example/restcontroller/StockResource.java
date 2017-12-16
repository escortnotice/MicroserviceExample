package com.example.restcontroller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("rest/stock")
public class StockResource {

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(groupKey="fallback", commandKey="fallback", fallbackMethod="getStockFallbackMethod")
	@SuppressWarnings("unchecked")
	@GetMapping("/{username}")
	public List<String> getStock(@PathVariable("username") final String username){
		System.out.println("beginning of db call");
		System.out.println("username: "+ username);
		List<String> quotes = restTemplate.getForObject("http://db-service/rest/db/userstockquotes/" + username, List.class);
		System.out.println("Count of quotes:"+ quotes.size());
		
		return quotes.stream()
				.map(quote -> {
					return getStockPrice(quote);
				})
				.collect(Collectors.toList());
		
	}
	
	private String getStockPrice(String quote){
		try {
			//return YahooFinance.get(quote);
			return "100.00";
		}
		catch(Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	//fallback method for any issue calling the other service, should have same signature as the method it is falling back for
	public List<String> getStockFallbackMethod(String userName){
		System.out.println("in fallback method");
		return Collections.emptyList();
	}
}
