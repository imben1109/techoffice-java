package com.techoffice.etnet.stock.realtime.crawler;

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
import com.techoffice.util.WebDriverUtil;

@Component
public class RealTimeStockCrawler {
	public static final String URL = "http://www.etnet.com.hk/www/tc/stocks/realtime/quote_super.php?code=";
	
	public String retrieveXmlByCode(String code) throws FailingHttpStatusCodeException, MalformedURLException, IOException, ParserConfigurationException, SAXException, XPathExpressionException, InterruptedException, TransformerException{
		String xml = WebDriverUtil.getXml(URL+code);
        return xml;
	}
	
}
