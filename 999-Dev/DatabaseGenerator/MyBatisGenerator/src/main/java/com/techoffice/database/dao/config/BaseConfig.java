package com.techoffice.database.dao.config;

import java.io.InputStream;
import java.util.Properties;

public class BaseConfig {

	public static String APP_PROPERTIES_FILE = "application.properties";
	public static Properties prop = null;
	
	static {
		try {
			// load properties
			InputStream inputStream = BaseConfig.class.getClassLoader().getResourceAsStream(APP_PROPERTIES_FILE);
			prop = new Properties();
			prop.load(inputStream);
			inputStream.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Properties getProperties(){
		return prop;
	}


}
