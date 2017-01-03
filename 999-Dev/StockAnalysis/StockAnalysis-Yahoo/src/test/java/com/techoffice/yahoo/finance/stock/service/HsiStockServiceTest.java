package com.techoffice.yahoo.finance.stock.service;

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
import com.techoffice.yahoo.finance.stock.model.HsiStock;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class HsiStockServiceTest {
	
	@Autowired
	private HsiStockService hsiStockService;

//	@Test
	public void updateHsiStockList() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException{
		hsiStockService.updateHsiStockList();
	}
	
	@Test
	public void list(){
		List<HsiStock> list = hsiStockService.list();
		for (HsiStock hsiStock: list){
			System.out.println(hsiStock.getChiName());
		}
	}

}
