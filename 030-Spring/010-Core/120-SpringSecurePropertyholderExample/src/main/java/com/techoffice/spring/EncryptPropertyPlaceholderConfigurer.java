package com.techoffice.spring;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.techoffice.security.CipherUtil;

public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer{
	
	private static final String ENCRYPTED_VALUE_PREFIX = "ENC(";
	private static final String ENCRYPTED_VALUE_SUFFIX = ")";
	
	@Override
	public String convertPropertyValue(String originalValue){
		if (isEncryptedValue(originalValue)){
			return CipherUtil.decrypt(getInnerEncyptedValue(originalValue));
		}
		return originalValue;
	}
	
	private boolean isEncryptedValue(String value){
		if (value.startsWith(ENCRYPTED_VALUE_PREFIX) && value.endsWith(ENCRYPTED_VALUE_SUFFIX)){
			return true;
		}
		return false;
	}
	
	private String getInnerEncyptedValue(String value){
		return value.substring(ENCRYPTED_VALUE_PREFIX.length(), value.length() - ENCRYPTED_VALUE_SUFFIX.length());
	}
}
