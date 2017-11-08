package com.techoffice.example.dao;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class TestDao {
	
	@Cacheable(cacheNames="test")
	public String get(){
		System.out.println("Executed TestDao Get");
		return "Hello";
	}

	@CachePut(cacheNames="test")
	public String put(){
		return "update";
	}
	
}
