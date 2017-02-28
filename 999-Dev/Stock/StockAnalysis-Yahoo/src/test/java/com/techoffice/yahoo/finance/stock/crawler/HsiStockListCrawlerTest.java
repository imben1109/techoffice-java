package com.techoffice.yahoo.finance.stock.crawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.techoffice.util.exception.XmlUtilDocumentConversionException;
import com.techoffice.yahoo.finance.stock.model.HsiStock;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class HsiStockListCrawlerTest {
	
	@Autowired
	private HsiStockCrawler hsiStockCrawler;
	
	@Test
	public void retrieveStockList() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException, XmlUtilDocumentConversionException{
		List<HsiStock> hsiStockList = hsiStockCrawler.retrieveStockList();
		for (HsiStock stock: hsiStockList){
			System.out.println(stock.getChiName());
		}
	}
	
}
