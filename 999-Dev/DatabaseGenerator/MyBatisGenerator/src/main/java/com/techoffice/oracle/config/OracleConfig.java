package com.techoffice.oracle.config;

import java.util.Properties;

import com.techoffice.database.config.BaseConfig;
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
			// load properties
			prop = BaseConfig.getProperties();
			
			// load Database Connection
			Class.forName("com.techoffice.oracle.connection.OracleDatabaseConnection");
			// load Entity Dao
			Class.forName("com.techoffice.oracle.dao.OracleEntityDao");
		} catch (Exception e) {
			throw new RuntimeException(e);
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
