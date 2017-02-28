package com.techoffice.aastock.stock.crawler;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.techoffice.util.SpecialStringUtil;
import com.techoffice.util.WebDriverUtil;
import com.techoffice.util.XmlUtil;
import com.techoffice.util.exception.XmlUtilDocumentConversionException;

@Service
public class EarningSummaryCrawler {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	public static final String URL = "http://www.aastocks.com/en/stocks/analysis/company-fundamental/earnings-summary?symbol=";
	
	public String getXml(String symbol){
		String xml = WebDriverUtil.getXml(URL + symbol);
		return xml;
	}
	
	public void getYearList(String symbol) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException, XmlUtilDocumentConversionException{
		String xml = getXml(symbol);
		String xpath = "//*[@id='highcharts-0']/svg/g[6]/text";
		NodeList rowNodeList = XmlUtil.evaluateXpath(xml, xpath);
		for (int i=0; i<rowNodeList.getLength(); i++){
			Node yearNode = rowNodeList.item(i);
			String yearValue = yearNode.getTextContent();
			yearValue = SpecialStringUtil.removeSpecialCharacter(yearValue);
			System.out.println(yearValue);
		}
	}
	
	public void getEarningPerShare(String symbol) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException, XmlUtilDocumentConversionException{
		String xml = getXml(symbol);
		String xpath = "//*[@id='cnhk-list']/tbody/tr[6]/td";
		NodeList rowNodeList = XmlUtil.evaluateXpath(xml, xpath);
		for (int i=1; i<rowNodeList.getLength()-1; i++){
			Node yearNode = rowNodeList.item(i);
			String yearValue = yearNode.getTextContent();
			yearValue = SpecialStringUtil.removeSpecialCharacter(yearValue);
			System.out.println(yearValue);
		}
	}
	
	public void getDividendPerShare(String symbol) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException, XmlUtilDocumentConversionException{
		String xml = getXml(symbol);
		String xpath = "//*[@id='cnhk-list']/tbody/tr[10]/td";
		NodeList rowNodeList = XmlUtil.evaluateXpath(xml, xpath);
		for (int i=1; i<rowNodeList.getLength()-1; i++){
			Node yearNode = rowNodeList.item(i);
			String yearValue = yearNode.getTextContent();
			yearValue = SpecialStringUtil.removeSpecialCharacter(yearValue);
			System.out.println(yearValue);
		}
	}
}
