package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Quotes;
import com.example.service.QuotesService;

@RestController
@RequestMapping("/rest/db")
public class QuotesRestController {
	
	@Autowired
	QuotesService quotesService;
	
	@GetMapping("/userstockquotes/{username}")
	public List<String> getQuotes(@PathVariable("username") final String username){
		return quotesService.getStockQuotesForTheUser(username);
	}
	
	@PostMapping("/userstockquotes/add")
	public List<String> addQuotes(@RequestBody final Quotes quotes){
		return quotesService.addQuotesForUser(quotes);
	}
	
	@DeleteMapping("/userstockquotes/delete/{username}")
	public List<String> deleteQuotes(@PathVariable("username") final String username){
		return quotesService.deleteQuotes(username);	
		}

}
