package com.techoffice.aastock.stock.crawler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.techoffice.aastock.stock.model.Industry;
import com.techoffice.util.DateUtil;
import com.techoffice.util.SpecialStringUtil;
import com.techoffice.util.WebDriverUtil;
import com.techoffice.util.XmlUtil;
import com.techoffice.util.exception.WebCrawlerException;

/**
 * A Web Crawler for 
 * http://www.aastocks.com/en/stocks/market/industry/industry-performance.aspx
 * 
 * @author imben1109
 *
 */
@Component
public class IndustryCrawler {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	public static final String URL = "http://www.aastocks.com/en/stocks/market/industry/industry-performance.aspx";
		
	public List<Industry> retrieveIndustryList() {
		List<Industry> industries = new ArrayList<Industry>();
		String xml = WebDriverUtil.getXml(URL);
		String xPath = "//*[@id='IndustyMain']/div[3]/div[1]/table/tbody/tr";
		
			String remarkStatement = XmlUtil.getXpathText(xml, "//*[@id='IndustyMain']/div[3]/div[2]");
			String updatedDateStatement = remarkStatement.replace("(1) Chg.% is calculated as the average percentage change of stocks in corresponding industries. Information delayed at least 15 minutes. Last Update: ", "");
			Date updatedDate = DateUtil.parseDate(updatedDateStatement, "yyyy/MM/dd HH:mm");
			NodeList rowNodeList = XmlUtil.evaluateXpath(xml, xPath);
			for (int i=1; i<rowNodeList.getLength(); i++){
				Node rowNode = rowNodeList.item(i);
				String rowNodeXml = XmlUtil.covertNodeToXmlString(rowNode);
				NodeList industryNodeList = XmlUtil.evaluateXpath(rowNodeXml, "//td[1]/table[1]/tbody/tr/td[2]/a");
				Node industryNode = industryNodeList.item(0);
				
				String industryName = industryNode.getTextContent();
				String url = industryNode.getAttributes().getNamedItem("href").getNodeValue();
				String industrySymbol = url.replace("/en/stocks/market/industry/sector-industry-details.aspx?industrysymbol=", "");
				
				industryName = SpecialStringUtil.removeSpecialCharacter(industryName);
				String chgPct = XmlUtil.getXpathText(rowNodeXml, "/tr/td[2]/span");
				String prevChgPct = XmlUtil.getXpathText(rowNodeXml, "/tr/td[3]/span");
				String turn = XmlUtil.getXpathText(rowNodeXml, "/tr/td[4]");
				String avgTurn5d = XmlUtil.getXpathText(rowNodeXml, "/tr/td[5]");
				String avgPe = XmlUtil.getXpathText(rowNodeXml, "/tr/td[6]");
				Industry industry = new Industry();
				industry.setUpdated(updatedDate);
				industry.setName(industryName);
				industry.setIndustrySymbol(industrySymbol);
				industry.setChgPct(chgPct);
				industry.setPrevChgPct(prevChgPct);
				industry.setTurn(turn);
				industry.setAvgTurn5d(avgTurn5d);
				industry.setAvgPe(avgPe);
				industries.add(industry);
			}
	

		return industries;
	}
}
