package com.techoffice.hkex.stock;

import java.io.File;
import java.io.IOException;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class StockAppConfiguration {
	
	public static final String CONFIG_FOLDER_NAME = ".ittechoffice";
	public static final String APP_PROPERTIES_FILE = "application.properties";
	public static final String PROXY_HOST = "proxy.host";
	public static final String PROXY_PORT = "proxy.port";
	public static final String RPOXY_USERNAME = "proxy.username";
	public static final String PROXY_PASSWORD = "proxy.password";
	public static final String PROXY_ENABLED = "proxy.enabled";
	
	public static Configuration config = null ;
    
	static {
		try {
			String homePath = System.getProperty("user.home");
			System.out.println("Home:" + homePath);
			String configFolderPath = homePath + "/" + CONFIG_FOLDER_NAME;
			File configFolder = new File(configFolderPath);
			File propertyFile = new File(configFolderPath, APP_PROPERTIES_FILE);
			if (!configFolder.exists()){
				configFolder.mkdirs();
				propertyFile.createNewFile();
			}
			Configurations configs = new Configurations();
		    config = configs.properties(propertyFile);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}
	
}
