package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Quote;
import com.example.model.Quotes;
import com.example.repository.QuotesRepository;

@Service
public class QuotesService {

	@Autowired
	private QuotesRepository quotesRepository;

	public List<String>  getStockQuotesForTheUser(String username) {
		List<Quote> quoteList = quotesRepository.findByUsername(username);
		// get only the stockquote names from List of Quote objects
		System.out.println("In DB Service: "+ username);
		return quoteList
				.stream()
				.map(Quote::getStockquote)
				.collect(Collectors.toList());
	}

	
	public List<String> addQuotesForUser(Quotes quotes){
		quotes.getQuotes().stream().map(quote -> new Quote(quotes.getUserName(),quote))
		.forEach(quote -> quotesRepository.save(quote));
		
		return getStockQuotesForTheUser(quotes.getUserName());
	}


	public List<String> deleteQuotes(String username) {
		List<Quote> quoteList = quotesRepository.findByUsername(username);
		quotesRepository.delete(quoteList);
		return getStockQuotesForTheUser(username);
		
	}
	
}
