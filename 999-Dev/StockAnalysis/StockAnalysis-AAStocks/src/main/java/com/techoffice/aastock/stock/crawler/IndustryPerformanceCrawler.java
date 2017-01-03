package com.techoffice.aastock.stock.crawler;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.techoffice.util.XmlUtil;

@Component
public class IndustryPerformanceCrawler {
	
	public static final String URL = "http://www.aastocks.com/tc/stocks/market/industry/industry-performance.aspx";
	
	@Autowired
	private WebClient webClient;
	
	public String retrieveXml() throws FailingHttpStatusCodeException, MalformedURLException, IOException{
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		final HtmlPage page = webClient.getPage(URL);
		String xml = page.asXml();
		webClient.close();
		return xml;
	}
	
	public void retrieveIndustryList() throws FailingHttpStatusCodeException, MalformedURLException, IOException, XPathExpressionException, ParserConfigurationException, SAXException{
		String xml = retrieveXml();
		String xPath = "//*[@id='IndustyMain']/div[6]/div[1]/table/tbody/tr[2]/td[1]/table/tbody/tr";
		NodeList rowNodeList = XmlUtil.evaluateXpath(xml, xPath);
		for (int i=0; i<rowNodeList.getLength(); i++){
			Node rowNode = rowNodeList.item(i);
			Node industryNode = rowNode.getChildNodes().item(3);
			String industryName = XmlUtil.getNodeText(industryNode);
			System.out.println(industryName);
		}
	}
}
