package com.techoffice.spring;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
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
	
//	@Override
//	protected String convertProperty(String propertyName, String propertyValue) {
//		System.out.println(propertyName);
//		return convertPropertyValue(propertyValue);
//	}
	
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		try {
			
			Properties properties = new Properties();
			properties.load(this.getClass().getClassLoader().getResourceAsStream("application.properties"));
			// Convert the merged properties, if necessary.
			convertProperties(properties);

			// Let the subclass process the properties.
			processProperties(beanFactory, properties);
		}
		catch (IOException ex) {
			throw new BeanInitializationException("Could not load properties", ex);
		}
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
