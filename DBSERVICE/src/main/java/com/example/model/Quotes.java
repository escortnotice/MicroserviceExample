package com.example.model;

import java.util.List;

public class Quotes {

	private String userName;
	private List<String>quotes;
	
	//setters and getters
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<String> getQuotes() {
		return quotes;
	}
	public void setQuotes(List<String> quotes) {
		this.quotes = quotes;
	}
	
	
}