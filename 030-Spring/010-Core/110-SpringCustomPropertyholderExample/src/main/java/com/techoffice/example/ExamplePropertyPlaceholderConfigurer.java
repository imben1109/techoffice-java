package com.techoffice.example;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class ExamplePropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer{
	
	private static final String ENCRYPTED_VALUE_PREFIX = "ENC(";
	private static final String ENCRYPTED_VALUE_SUFFIX = ")";
	
	@Override
	public String convertPropertyValue(String originalValue){
		if (isEncryptedValue(originalValue)){
			return "Encrypted Content";
		}
		return originalValue;
	}
	
	private boolean isEncryptedValue(String value){
		if (value.startsWith(ENCRYPTED_VALUE_PREFIX) && value.endsWith(ENCRYPTED_VALUE_SUFFIX)){
			return true;
		}
		return false;
	}
	
}
