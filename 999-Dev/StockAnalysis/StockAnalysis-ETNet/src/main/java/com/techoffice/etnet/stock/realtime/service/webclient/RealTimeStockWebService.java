package com.techoffice.etnet.stock.realtime.service.webclient;

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
public class RealTimeStockWebService {
	public static final String URL = "http://www.etnet.com.hk/www/tc/stocks/realtime/quote_super.php?code=";
	
	public String retrieveXml(String code) throws FailingHttpStatusCodeException, MalformedURLException, IOException, ParserConfigurationException, SAXException, XPathExpressionException, InterruptedException, TransformerException{
	    final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);
        final HtmlPage page = webClient.getPage(URL+code);
        String xml = page.asXml();
        webClient.close();
        return xml;
	}
	
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException, ParserConfigurationException, SAXException, XPathExpressionException, InterruptedException, TransformerException{
		RealTimeStockWebService stockListWeb = new RealTimeStockWebService();
		String xml = stockListWeb.retrieveXml("3988");
		System.out.println(xml);
	}
}
