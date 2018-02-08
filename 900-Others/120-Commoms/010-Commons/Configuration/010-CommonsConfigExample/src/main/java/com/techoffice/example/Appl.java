package com.techoffice.example;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class Appl {
	public static void main(String[] args) throws ConfigurationException {
		Configurations configs = new Configurations();
		Configuration config = configs.properties(Appl.class.getClassLoader().getResource("config.properties"));
		System.out.println(config.getString("name"));
		
	}
}
