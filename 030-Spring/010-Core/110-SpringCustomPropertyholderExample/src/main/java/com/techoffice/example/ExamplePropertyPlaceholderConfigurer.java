package com.techoffice.example;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class ExamplePropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer{
	
	@Override
	public String convertPropertyValue(String originalValue){
		return "Custom Content";
	}
	
}
