package com.techoffice.aastock.stock.service.webclient;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

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
	
	public void retrieveStockListByWebClient() throws FailingHttpStatusCodeException, MalformedURLException, IOException, ParserConfigurationException, SAXException, XPathExpressionException, InterruptedException, TransformerException{
	    final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);
        final HtmlPage page = webClient.getPage(URL);
        String xml = page.asXml();
        webClient.close();
	}
	
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException, ParserConfigurationException, SAXException, XPathExpressionException, InterruptedException, TransformerException{
		StockListWebService stockListWeb = new StockListWebService();
		stockListWeb.retrieveStockListByWebClient();
	}
}
