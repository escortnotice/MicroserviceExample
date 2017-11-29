package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="quotes")
public class Quote {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "id")
	private long id;
	
	private String username;
	
	private String stockquote;

	//constructors
	public Quote() {
		
	}
	
	public Quote(String username, String stockquote) {
		this.username = username;
		this.stockquote = stockquote;
	}
	
	//setters and getters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStockquote() {
		return stockquote;
	}

	public void setStockquote(String stockquote) {
		this.stockquote = stockquote;
	}
	
	
}
