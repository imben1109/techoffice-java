package com.techoffice.example.mvn;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApplProperty {
	public static final String CONFIG_FOLDER_NAME = ".ittechoffice";
	public static final String APP_PROPERTIES_FILE = "application.properties";
	public static final String EXAMPLE_HOME = "example_home";
	
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
	
	public static String getExampleHome(){
		String exampleHome = ApplProperty.properties.getProperty(ApplProperty.EXAMPLE_HOME);
		return exampleHome;
	}
}
