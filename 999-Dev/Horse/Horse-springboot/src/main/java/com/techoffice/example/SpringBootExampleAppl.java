package com.techoffice.example;

import javax.xml.xpath.XPathExpressionException;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.techoffice.example.config.Config;
import com.techoffice.util.exception.XmlUtilDocumentConversionException;


public class SpringBootExampleAppl {
	
	public static void main(String[] args) throws XPathExpressionException, XmlUtilDocumentConversionException{
        ConfigurableApplicationContext context = SpringApplication.run(Config.class);
	}
}
