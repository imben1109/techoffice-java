package com.techoffice.yahoo.finance.stock.service.webclient;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

@Component
public class StockListWebService {
	public static final String URL = "https://www.hkex.com.hk/eng/market/sec_tradinfo/stockcode/eisdeqty.htm";
	public static final String CHI_URL = "https://www.hkex.com.hk/chi/market/sec_tradinfo/stockcode/eisdeqty_c.htm";
	
	@Autowired
	private WebClient webClient; 
	
	public String retrieveStockListByWebClient() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
        final HtmlPage page = webClient.getPage(URL);
        String xml = page.asXml();
        return xml;
	}
	
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException, ParserConfigurationException, SAXException, XPathExpressionException, InterruptedException, TransformerException{
		StockListWebService stockListWeb = new StockListWebService();
		String xml = stockListWeb.retrieveStockListByWebClient();
		System.out.println(xml);
	}
}
