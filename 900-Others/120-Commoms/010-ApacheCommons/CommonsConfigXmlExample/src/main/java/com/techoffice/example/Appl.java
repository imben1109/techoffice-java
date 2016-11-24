package com.techoffice.example;

import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class Appl {
	public static void main(String[] args) throws ConfigurationException{
		Parameters params = new Parameters();
		FileBasedConfigurationBuilder<XMLConfiguration> builder =
			    new FileBasedConfigurationBuilder<XMLConfiguration>(XMLConfiguration.class)
			    .configure(params.xml()
			        .setFileName("config.xml")
			        .setSchemaValidation(false));
		XMLConfiguration  xmlConfiguration  = builder.getConfiguration();
		String name = xmlConfiguration.getString("name");
		String additionContent = xmlConfiguration.getString("addition.content");
		System.out.println(name);
		System.out.println(additionContent);
	}
}
