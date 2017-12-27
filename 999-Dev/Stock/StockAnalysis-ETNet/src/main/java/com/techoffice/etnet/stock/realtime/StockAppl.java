package com.techoffice.etnet.stock.realtime;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.techoffice.etnet.stock.realtime.crawler.RealTimeStockCrawler;

@Component
public class StockAppl {
	
	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	
	@Autowired
	private RealTimeStockCrawler realTimeStockWebService;
	
	@Transactional
	public void run() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException{
		String xml = realTimeStockWebService.retrieveXmlByCode("3988");
		System.out.println(xml);
	}
	
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException{
		StockAppl appl = context.getBean(StockAppl.class);
		appl.run();
	}
}
