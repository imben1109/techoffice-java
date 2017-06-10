package com.techoffice.oracle.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Config {
	
	public static String APP_PROPERTIES_FILE = "application.properties";
	public static Properties prop = null;
    
	public static final String ORACLE_CONNECTION_USER = "oracle.connection.user";
	public static final String ORACLE_CONNECTION_PASSWORD = "oracle.connection.password";
	public static final String ORACLE_CONNECTION_URL = "oracle.connection.url";
	
	static {
		try {
			InputStream inputStream = Config.class.getClassLoader().getResourceAsStream(APP_PROPERTIES_FILE);
			prop = new Properties();
			prop.load(inputStream);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getOracleConnectionUser(){
		return prop.getProperty(ORACLE_CONNECTION_USER, "");
	}
	
	public static String getOracleConnectionPassword(){
		return prop.getProperty(ORACLE_CONNECTION_PASSWORD, "");
	}
	
	public static String getOracleConnectionUrl(){
		return prop.getProperty(ORACLE_CONNECTION_URL, "");	
	}
}
