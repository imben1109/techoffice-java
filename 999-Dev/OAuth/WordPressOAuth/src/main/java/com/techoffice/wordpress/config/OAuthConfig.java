package com.techoffice.wordpress.config;

import java.io.File;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class OAuthConfig {
	public static final String APP_PROPERTIES_FILE = "oauth.properties";
	
	public static final String CLIENT_ID = "client_id";
	public static final String CLIENT_SECRET = "client_secret";
	public static final String APPL_HOST = "appl_host";
	
	private static Configuration config = null ;
	
	static {
		try {
			File propertyFile = new File(APP_PROPERTIES_FILE);
			Configurations configs = new Configurations();
		    config = configs.properties(propertyFile);

		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	public static String getClientId(){
		return config.getString(CLIENT_ID);
	}
	
	public static String getClientSecret(){
		return config.getString(CLIENT_SECRET);
	}
	
	public static String getApplHost(){
		return config.getString(APPL_HOST);
	}
	
	public static void main(String[] args){
		System.out.println(OAuthConfig.getClientId());
	}
	
}
