package com.techoffice.oracle.javamodel.config;

import java.io.File;
import java.io.IOException;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class OracleConfig {
	public static final String CONFIG_FOLDER_NAME = ".ittechoffice";
	public static final String APP_PROPERTIES_FILE = "application.properties";
	public static final String EXAMPLE_HOME = "example_home";
	public static final String GIT_USER = "git_user";
	public static final String GIT_PASSWORD = "git_password";
	public static final String PROXY_HOST = "proxy.host";
	public static final String PROXY_PORT = "proxy.port";
	public static final String PROXY_USERNAME = "proxy.username";
	public static final String PROXY_PASSWORD = "proxy.password";
	public static final String PROXY_ENABLED = "proxy.enabled";
	public static final String HTMLUNIT_LOGGING = "htmlunit.logging";
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
	
	public static boolean isProxyEnabled(){
		return config.getBoolean(PROXY_ENABLED, false);
	}
	
	public static String getProxyHost(){
		return config.getString(PROXY_HOST);
	}
	
	public static String getProxyPort(){
		return config.getString(PROXY_PORT);
	}
	
	public static String getProxyUsername(){
		return config.getString(PROXY_USERNAME);
	}
	
	public static String getProxyPassword(){
		return config.getString(PROXY_PASSWORD);
	}
	
	public static boolean isHtmlUnitLogging(){
		return config.getBoolean(HTMLUNIT_LOGGING, false);
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
