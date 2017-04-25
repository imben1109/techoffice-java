package com.techoffice.aastock.stock;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

@Component
public class StockAppl {
	
	@Transactional
	public void run() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException{

	}
	
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException{
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		try{
			StockAppl appl = context.getBean(StockAppl.class);
			appl.run();
		}finally {
			context.close();
		}
		
	}
}
