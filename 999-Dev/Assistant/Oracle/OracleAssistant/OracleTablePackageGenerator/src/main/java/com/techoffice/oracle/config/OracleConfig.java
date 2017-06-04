package com.techoffice.oracle.config;

import java.io.File;
import java.io.IOException;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class OracleConfig {
	public static final String APP_PROPERTIES_FILE = "application.properties";
	public static final String ORACLE_CONNECTION_URL = "oracle.connection.url";
	public static final String ORACLE_CONNECTION_USER = "oracle.connection.user";
	public static final String ORACLE_CONNECTION_PASSWORD = "oracle.connection.password";
	public static final String ORACLE_GENERATOR_TABLE = "oracle.generator.table";
	public static final String ORACLE_GENERATOR_PACKAGE = "oracle.generator.package";
	
	public static Configuration config = null ;
    
	static {
		try {
			File propertyFile = new File(OracleConfig.class.getClassLoader().getResource(APP_PROPERTIES_FILE).getFile());			
			System.out.println(propertyFile.getAbsolutePath());
			Configurations configs = new Configurations();
		    config = configs.properties(propertyFile);
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	
	public static String getOracleConntectionUrl(){
		return config.getString(ORACLE_CONNECTION_URL);
	}
	
	public static String getOracleConnectionUser(){
		return config.getString(ORACLE_CONNECTION_USER);
	}
	
	public static String getOracleConnectionPassword(){
		return config.getString(ORACLE_CONNECTION_PASSWORD);
	}
	
	public static String getGeneratorTable(){
		return config.getString(ORACLE_GENERATOR_TABLE);
	}
	
	public static String getGeneratorPackage(){
		return config.getString(ORACLE_GENERATOR_PACKAGE);
	}
}
