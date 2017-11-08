package com.techoffice.yahoo.finance.stock.crawler;

import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.techoffice.util.WebDriverUtil;
import com.techoffice.util.XmlUtil;
import com.techoffice.util.exception.XmlUtilInvalidDocumentException;
import com.techoffice.yahoo.finance.stock.model.HsiStock;

@Component
public class HsiStockCrawler {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	public static final String URL = "https://hk.finance.yahoo.com/q/cp?s=%5EHSI";

	public String retrieveXml() {
		String xml = WebDriverUtil.getXml(URL);
        return xml;
	}
	
	public List<HsiStock> retrieveStockList() throws XPathExpressionException, XmlUtilInvalidDocumentException {
		List<HsiStock> hsiStockList = new ArrayList<HsiStock>();
		String xPath = "//*[@id='quote-leaf-comp']/section/section/table/tbody/tr";
		String xml = retrieveXml();
		NodeList stockNodeList = XmlUtil.evaluateXpath(xml, xPath);
		for (int i=1; i<stockNodeList.getLength(); i++){
			Node stockRowNode = stockNodeList.item(i);
			NodeList stockRowNodeList = stockRowNode.getChildNodes();
			Node stockNoNode = stockRowNodeList.item(1);
			Node stockNameNode = stockRowNodeList.item(3);
			String stockNoText = XmlUtil.getNodeText(stockNoNode);
			stockNoText = stockNoText.replace(".HK", "");
			String stockNameText = XmlUtil.getNodeText(stockNameNode);
			HsiStock hsiStock = new HsiStock();
			hsiStock.setStockNo(stockNoText);
			hsiStock.setChiName(stockNameText);
			hsiStockList.add(hsiStock);
		}
		return hsiStockList;
	}
}
