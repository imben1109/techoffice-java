package com.techoffice.aastock.stock.crawler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.techoffice.util.SpecialStringUtil;
import com.techoffice.util.WebDriverUtil;
import com.techoffice.util.XmlUtil;


/**
 * A Web Crawler for 
 * http://www.aastocks.com/en/stocks/analysis/company-fundamental/earnings-summary?symbol=
 * 
 * @author imben1109
 *
 */
@Component
public class EarningSummaryCrawler {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	public static final String URL = "http://www.aastocks.com/en/stocks/analysis/company-fundamental/earnings-summary?symbol=";
	
	public List<String> getYearList(String symbol) {
		List<String> yearList = new ArrayList<String>();
		String xml = WebDriverUtil.getXml(URL + symbol);
		String xpath = "//*[@id='highcharts-0']/svg/g[6]/text";
		NodeList rowNodeList = XmlUtil.evaluateXpath(xml, xpath);
		for (int i=0; i<rowNodeList.getLength(); i++){
			Node yearNode = rowNodeList.item(i);
			String yearValue = yearNode.getTextContent();
			yearValue = SpecialStringUtil.removeSpecialCharacter(yearValue);
			yearList.add(yearValue);
		}
		return yearList;
	}
	
	public List<String> getEarningPerShare(String symbol) {
		List<String> earningPerShareList = new ArrayList<String>();
		String xml = WebDriverUtil.getXml(URL + symbol);
		String xpath = "//*[@id='cnhk-list']/tbody/tr[6]/td";
		NodeList rowNodeList = XmlUtil.evaluateXpath(xml, xpath);
		for (int i=1; i<rowNodeList.getLength()-1; i++){
			Node yearNode = rowNodeList.item(i);
			String earningPerShare = yearNode.getTextContent();
			earningPerShare = SpecialStringUtil.removeSpecialCharacter(earningPerShare);
			earningPerShareList.add(earningPerShare);
		}
		return earningPerShareList;
	}
	
	public List<String> getDividendPerShare(String symbol) {
		List<String> dividendPerShareList = new ArrayList<String>();
		String xml = WebDriverUtil.getXml(URL + symbol);
		String xpath = "//*[@id='cnhk-list']/tbody/tr[10]/td";
		NodeList rowNodeList = XmlUtil.evaluateXpath(xml, xpath);
		for (int i=1; i<rowNodeList.getLength()-1; i++){
			Node yearNode = rowNodeList.item(i);
			String dividendPerShare = yearNode.getTextContent();
			dividendPerShare = SpecialStringUtil.removeSpecialCharacter(dividendPerShare);
			dividendPerShareList.add(dividendPerShare);
		}
		return dividendPerShareList;
	}
}
