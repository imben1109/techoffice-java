package com.techoffice.h2.config;

import java.util.Properties;

import com.techoffice.database.config.BaseConfig;
import com.techoffice.database.config.annoation.JdbcTypeMapping;
import com.techoffice.database.config.annoation.JdbcTypeMappings;

@JdbcTypeMappings({
	@JdbcTypeMapping(value = "DECIMAL", javaFullType = "java.lang.Integer", condition = "field.scale == 0"),
	@JdbcTypeMapping(value = "DECIMAL", javaFullType = "java.math.BigDecimal", condition="field.scale != 0"),
	@JdbcTypeMapping(value = "VARCHAR", javaFullType="java.lang.String"),
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
			prop = BaseConfig.getProperties();
			
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
