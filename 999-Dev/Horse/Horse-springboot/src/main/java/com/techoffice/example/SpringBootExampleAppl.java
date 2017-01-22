package com.techoffice.example;

import javax.xml.xpath.XPathExpressionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.techoffice.jc.horse.crawler.CurrentOddsCrawler;
import com.techoffice.util.exception.XmlUtilDocumentConversionException;

@Component
public class SpringBootExampleAppl {
	
	@Autowired
	private CurrentOddsCrawler currentOddsCrawler;
	
	public void run() throws XPathExpressionException, XmlUtilDocumentConversionException {
		currentOddsCrawler.getRaceNums();
	}
	
	public static void main(String[] args) throws XPathExpressionException, XmlUtilDocumentConversionException{
        ConfigurableApplicationContext context = SpringApplication.run(Config.class);
        SpringBootExampleAppl appl =  context.getBean(SpringBootExampleAppl.class);
        appl.run();
	}
}
