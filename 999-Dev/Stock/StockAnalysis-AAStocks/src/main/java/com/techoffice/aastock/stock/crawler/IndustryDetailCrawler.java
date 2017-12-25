package com.techoffice.aastock.stock.crawler;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.techoffice.aastock.stock.model.IndustryDetail;
import com.techoffice.util.WebDriverUtil;
import com.techoffice.util.XmlUtil;
import com.techoffice.util.exception.WebCrawlerException;

/**
 * A Web Crawler for 
 * http://www.aastocks.com/en/stocks/market/industry/sector-industry-details.aspx
 * 
 * @author imben1109
 *
 */
@Component
public class IndustryDetailCrawler {

	private Logger log  = LoggerFactory.getLogger(this.getClass());
	
	public static final String URL = "http://www.aastocks.com/en/stocks/market/industry/sector-industry-details.aspx?industrysymbol=";

	public List<IndustryDetail> retrieve(String industrySymbol) throws WebCrawlerException{
		List<IndustryDetail> industryDetails = new ArrayList<IndustryDetail>();
		String xml = WebDriverUtil.getXml(URL + industrySymbol); 
		try {
			String remark = XmlUtil.getXpathText(xml, "//*[@id='IndustyMain']/div[5]/div[3]");
			String lastUpdatedStatement = remark.replace("(1) Information delayed at least 15 minutes Last Update: ", "");
			NodeList rowList = XmlUtil.evaluateXpath(xml, "//*[@id='tbTS']/tbody/tr");
			log.info("Number of stock found in this industry [" + industrySymbol +"]: " + rowList.getLength());
			for (int i=0; i < rowList.getLength(); i++){
				Node rowNode = rowList.item(i);
				String rowXml = XmlUtil.covertNodeToXmlString(rowNode);
				String name = XmlUtil.getXpathText(rowXml, "//tr/td[1]/div[1]");
				String symbol = XmlUtil.getXpathText(rowXml, "tr/td[1]/div[2]/div/span[1]");
				String last = XmlUtil.getXpathText(rowXml, "tr/td[3]");
				String chg= XmlUtil.getXpathText(rowXml, "tr/td[4]");
				String pctChg= XmlUtil.getXpathText(rowXml, "tr/td[5]");
				String volume = XmlUtil.getXpathText(rowXml, "tr/td[6]");
				String turnover = XmlUtil.getXpathText(rowXml, "tr/td[7]");
				String pe= XmlUtil.getXpathText(rowXml, "tr/td[8]");
				String pb = XmlUtil.getXpathText(rowXml, "tr/td[9]");
				String yeild = XmlUtil.getXpathText(rowXml, "tr/td[10]");
				String marketCap = XmlUtil.getXpathText(rowXml, "tr/td[11]");
				if (NumberUtils.isNumber(last)){
					IndustryDetail industryDetail = new IndustryDetail();
					industryDetail.setIndustrySymbol(industrySymbol);
					industryDetail.setName(name);
					industryDetail.setSymbol(symbol);
					industryDetail.setLast(Double.parseDouble(last));
					industryDetail.setChg(chg);
					industryDetail.setPctChg(pctChg);
					industryDetail.setVolume(volume);
					industryDetail.setTurnover(turnover);
					industryDetail.setPe(pe);
					industryDetail.setPb(pb);
					industryDetail.setYeild(yeild);
					industryDetail.setMarketCap(marketCap);
					industryDetails.add(industryDetail);
				}
			}
		} catch (Exception e) {
			log.error(xml);
			throw new WebCrawlerException("Industry Symbol: " + industrySymbol, e);
		}
		return industryDetails;
	}

}
