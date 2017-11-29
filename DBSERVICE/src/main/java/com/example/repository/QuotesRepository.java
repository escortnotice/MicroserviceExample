package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Quote;

public interface QuotesRepository extends JpaRepository<Quote, Long> {

	List<Quote> findByUsername(String username);
}
