package com.techoffice.h2.config;

import java.io.InputStream;
import java.util.Properties;

import com.techoffice.database.config.annoation.JdbcTypeMapping;
import com.techoffice.database.config.annoation.JdbcTypeMappings;

@JdbcTypeMappings({
	@JdbcTypeMapping(value = "NUMBER", javaFullType = "java.lang.Integer", condition = "field.scale == 0"),
	@JdbcTypeMapping(value = "NUMBER", javaFullType = "java.math.BigDecimal", condition="field.scale != 0"),
	@JdbcTypeMapping(value = "VARCHAR2", javaFullType="java.lang.String"),
	@JdbcTypeMapping(value = "DATE", javaFullType = "java.util.Date")
})
public class H2Config {

	public static String APP_PROPERTIES_FILE = "application.properties";
	public static Properties prop = null;
    
	public static final String H2_CONNECTION_USER = "h2.connection.user";
	public static final String H2_CONNECTION_PASSWORD = "h2.connection.password";
	public static final String H2_CONNECTION_URL = "h2.connection.url";
	
	static {
		try {
			// load properties
			InputStream inputStream = H2Config.class.getClassLoader().getResourceAsStream(APP_PROPERTIES_FILE);
			prop = new Properties();
			prop.load(inputStream);
			inputStream.close();
			
			// load Database Connection
			Class.forName("com.techoffice.h2.connection.H2DatabaseConnection");
			// load Entity Dao
			Class.forName("com.techoffice.h2.dao.H2EntityDao");
		} catch (Exception e) {
			throw new RuntimeException(e);
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
