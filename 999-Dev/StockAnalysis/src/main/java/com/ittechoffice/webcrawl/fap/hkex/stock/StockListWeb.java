package com.ittechoffice.webcrawl.fap.hkex.stock;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.ittechoffice.webcrawl.fap.hkex.stock.model.Stock;

@Component
public class StockListWeb {
	public static final String URL = "https://www.hkex.com.hk/eng/market/sec_tradinfo/stockcode/eisdeqty.htm";
	public static final String CHI_URL = "https://www.hkex.com.hk/chi/market/sec_tradinfo/stockcode/eisdeqty_c.htm";
	
	public List<Stock> retrieveStockListByWebClient() throws FailingHttpStatusCodeException, MalformedURLException, IOException, ParserConfigurationException, SAXException, XPathExpressionException, InterruptedException, TransformerException{
	    final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);
        final HtmlPage page = webClient.getPage(URL);
        String xml = page.asXml();
        List<Stock> stocks = parseXml(xml);
        webClient.close();
		return stocks;
	}
	
	private List<Stock> parseXml(String xml) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException, TransformerException{
		List<Stock> stocks = new ArrayList<Stock>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(new ByteArrayInputStream(xml.getBytes()));
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();
		XPathExpression expr = xpath.compile("/html/body/center/table/tbody/tr[1]/td[2]/table/tbody/tr[6]/td/table/tbody/tr/td[2]/printfriendly/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr");
		NodeList tableNodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
		for (int i=0; i<tableNodeList.getLength(); i++){
			Node row = tableNodeList.item(i);
			NodeList cols = row.getChildNodes();
			for (int j=0; j<cols.getLength(); j++){
				if (j<4){
					Stock stock = new Stock();
					Node col = cols.item(j);
					if (j==1){
						String stockCode = col.getTextContent().trim();
						stock.setStockCode(stockCode);
					}
					if (j==3){
						String stockName = col.getTextContent().trim();
						stock.setName(stockName);
					}
					stocks.add(stock);
				}
			}
		}
		return stocks;
	}
	
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException, ParserConfigurationException, SAXException, XPathExpressionException, InterruptedException, TransformerException{
		StockListWeb stockListWeb = new StockListWeb();
		stockListWeb.retrieveStockListByWebClient();
	}
}
