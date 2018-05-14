package com.techoffice.oracle.config;

import java.io.IOException;
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
public class OracleConfig {
	
	public static String APP_PROPERTIES_FILE = "application.properties";
	public static Properties prop = null;
    
	public static final String ORACLE_CONNECTION_USER = "oracle.connection.user";
	public static final String ORACLE_CONNECTION_PASSWORD = "oracle.connection.password";
	public static final String ORACLE_CONNECTION_URL = "oracle.connection.url";
	
	static {
		try {
			InputStream inputStream = OracleConfig.class.getClassLoader().getResourceAsStream(APP_PROPERTIES_FILE);
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
