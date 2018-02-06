package com.techoffice.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Properties;

public class Appl {
	public static void main(String[] args) throws IOException, URISyntaxException{
		Properties prop = new Properties();
		InputStream propResource = Appl.class.getClassLoader().getResourceAsStream("application.properties");
		prop.load(propResource);
		propResource.close();
		
		System.out.println(prop.getProperty("test"));
		System.out.println(prop.getProperty("test1"));
	}
}
