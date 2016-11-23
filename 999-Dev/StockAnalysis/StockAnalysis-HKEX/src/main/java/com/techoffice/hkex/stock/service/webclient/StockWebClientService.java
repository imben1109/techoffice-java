package com.techoffice.hkex.stock.service.webclient;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.techoffice.hkex.stock.model.Stock;
import com.techoffice.util.XmlUtil;

@Component
public class StockWebClientService {
	
	final Logger log = LoggerFactory.getLogger(this.getClass());		

	public static final String URL = "https://www.hkex.com.hk/eng/market/sec_tradinfo/stockcode/eisdeqty.htm";
	
	@Autowired
	private WebClient webClient; 
	
	public List<Stock> retrieveStockListByWebClient() throws FailingHttpStatusCodeException, MalformedURLException, IOException, ParserConfigurationException, SAXException, XPathExpressionException, InterruptedException, TransformerException{
        final HtmlPage page = webClient.getPage(URL);
        String xml = page.asXml();
        List<Stock> stocks = parseXml(xml);
        webClient.close();
		return stocks;
	}
	
	private List<Stock> parseXml(String xml) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException, TransformerException{
		List<Stock> stocks = new ArrayList<Stock>();
		String xPath = "/html/body/center/table/tbody/tr[1]/td[2]/table/tbody/tr[6]/td/table/tbody/tr/td[2]/printfriendly/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr";
		NodeList tableNodeList = XmlUtil.evaluateXpath(xml, xPath);
		if (tableNodeList.getLength() > 0 ){
			for (int i=1; i<tableNodeList.getLength(); i++){
				Node row = tableNodeList.item(i);
				NodeList cols = row.getChildNodes();
				Stock stock = new Stock();
				for (int j=0; j<cols.getLength(); j++){
					if (j<4){
						Node col = cols.item(j);
						if (j==1){
							String stockCode = col.getTextContent().trim();
							stock.setStockCode(stockCode);
						}
						if (j==3){
							if (col.getChildNodes().item(1) != null ){
								String stockName = col.getChildNodes().item(1).getFirstChild().getTextContent().trim();
								stock.setName(stockName);	
							}
						}
					}
				}
				stocks.add(stock);
			}	
		}
		return stocks;
	}
	
}
