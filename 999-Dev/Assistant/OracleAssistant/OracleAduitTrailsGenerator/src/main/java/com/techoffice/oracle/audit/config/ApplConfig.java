package com.techoffice.oracle.audit.config;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class ApplConfig {
	private static XMLConfiguration config = new XMLConfiguration();
	static {
		try {
			Configurations configs = new Configurations();
			config = configs.xml(ApplConfig.class.getClassLoader().getResource("config.xml"));
		} catch (ConfigurationException e) {
			e.printStackTrace();
		} 
	}
	public static String getString(String str){
		return config.getString(str);
	}
	public static int getInt(String key){
		return config.getInt(key);
	}
	public static boolean getBoolean(String key){
		return config.getBoolean(key);
	}
	public static Configuration getConfig(){
		return config;
	}
	public static void main(String[] args){
		System.out.println(ApplConfig.getString("name"));
	}
}
