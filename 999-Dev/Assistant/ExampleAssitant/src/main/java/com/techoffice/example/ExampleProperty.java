package com.techoffice.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ExampleProperty {
	
	public static final String CONFIG_FOLDER_NAME = ".ittechoffice";
	public static final String APP_PROPERTIES_FILE = "application.properties";
	public static final String EXAMPLE_HOME = "example_home";
	public static final String GIT_USER = "git_user";
	public static final String GIT_PASSWORD = "git_password";
	public static final String PROXY_HOST = "proxy.host";
	public static final String PROXY_PORT = "proxy.port";
	public static final String RPOXY_USER = "proxy.username";
	public static final String PROXY_PASSWORD = "proxy.password";
	
	public static Properties properties  = null;
	
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
			FileInputStream inputStream = new FileInputStream(propertyFile);
			properties = new Properties();
			properties.load(inputStream);
			inputStream.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception{
		String exampleHome = ExampleProperty.properties.getProperty(ExampleProperty.EXAMPLE_HOME);
		if (exampleHome == null){
			throw new Exception("Cannot Find Example Project Home");
		}
		System.out.println("Project root: " + exampleHome);
	}
}
