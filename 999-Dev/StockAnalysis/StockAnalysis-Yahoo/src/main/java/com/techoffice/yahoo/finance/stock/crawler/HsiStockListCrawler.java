package com.techoffice.yahoo.finance.stock.crawler;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
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
public class HsiStockListCrawler {
	
	public static final String URL = "https://hk.finance.yahoo.com/q/cp?s=%5EHSI";

	@Autowired
	private WebClient webClient;

	public String retrieveXml() throws FailingHttpStatusCodeException, MalformedURLException, IOException, ParserConfigurationException, SAXException, XPathExpressionException, InterruptedException, TransformerException{
		webClient.getOptions().setThrowExceptionOnScriptError(false);
        final HtmlPage page = webClient.getPage(URL);
        String xml = page.asXml();
        webClient.close();
        webClient.getOptions().setThrowExceptionOnScriptError(true);
        return xml;
	}
	
	public void retrieveStockList() throws FailingHttpStatusCodeException, MalformedURLException, XPathExpressionException, IOException, ParserConfigurationException, SAXException, InterruptedException, TransformerException{
		String xPath = "//*[@id='yfncsumtab']/tbody/tr[2]/td[1]/table[2]/tbody/tr/td/table/tbody/tr";
		String xml = retrieveXml();
		NodeList stockNodeList = XmlUtil.evaluateXpath(xml, xPath);
		for (int i=1; i<stockNodeList.getLength(); i++){
			Node stockRowNode = stockNodeList.item(i);
			NodeList stockRowNodeList = stockRowNode.getChildNodes();
			Node stockNoNode = stockRowNodeList.item(1);
			Node stockNameNode = stockRowNodeList.item(3);
			String stockNoText = XmlUtil.getNodeText(stockNoNode);
			System.out.println(stockNoText);
			String stockNameText = XmlUtil.getNodeText(stockNameNode);
			System.out.println(stockNameText);
		}
	}
}
