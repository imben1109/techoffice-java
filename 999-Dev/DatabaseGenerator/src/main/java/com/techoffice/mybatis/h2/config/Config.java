package com.techoffice.mybatis.h2.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

	public static String APP_PROPERTIES_FILE = "application.properties";
	public static Properties prop = null;
    
	public static final String H2_CONNECTION_USER = "h2.connection.user";
	public static final String H2_CONNECTION_PASSWORD = "h2.connection.password";
	public static final String H2_CONNECTION_URL = "h2.connection.url";
	
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
	
	public static String getH2ConnectionUser(){
		return prop.getProperty(H2_CONNECTION_USER, "");
	}
	
	public static String getH2ConnectionPassword(){
		return prop.getProperty(H2_CONNECTION_PASSWORD, "");
	}
	
	public static String getH2ConnectionUrl(){
		return prop.getProperty(H2_CONNECTION_URL, "");	
	}
	
}
