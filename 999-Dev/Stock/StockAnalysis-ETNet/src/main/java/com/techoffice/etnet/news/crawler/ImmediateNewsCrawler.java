package com.techoffice.etnet.news.crawler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.techoffice.etnet.news.entity.AvailableNewsDate;
import com.techoffice.etnet.news.entity.News;
import com.techoffice.util.DateUtil;
import com.techoffice.util.WebDriverUtil;
import com.techoffice.util.XmlUtil;

/**
 * HKET News Crawler 
 * 
 * http://inews.hket.com/sran001
 * 
 * @author TechOffice
 *
 */
@Component
public class ImmediateNewsCrawler {

	public static final String TYPE = "IMMEDIATE";
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	public String getXml(){
		return WebDriverUtil.getXml("http://inews.hket.com/sran001");
	}
	
	public String getXml(String url){
		return WebDriverUtil.getXml(url);		
	}
	
	public List<News> getNewsList(){
		return getNewsList(null);
	}
	
	public List<News> getNewsList(String url){
		List<News> newList = new ArrayList<News>();
		String xml = null;
		if (url == null){
			xml = getXml();
		}else {
			log.info("Get News List: " + url);
			xml = getXml(url);
		}
		Date postDate = getPostDate(xml);
		List<String> newsList = XmlUtil.getNodeListText(xml, "//*[@id='eti-inews-list']/tbody/tr/td/a");
		for (String news: newsList){
			News crawledNews = new News();
			crawledNews.setContents(news);
			crawledNews.setPostDate(postDate);
			crawledNews.setType(TYPE);
			newList.add(crawledNews);
		}
		return newList;
	}
	
	public List<AvailableNewsDate> getAvailableDateList(){
		String xml = getXml();
		List<AvailableNewsDate> availNewsDateList = new ArrayList<AvailableNewsDate>();
		NodeList nodeList = XmlUtil.evaluateXpath(xml, "/html/body/div/div[4]/div[1]/div[2]/select/option");
		for (int i=0; i<nodeList.getLength(); i++){
			Node node = nodeList.item(i);
			String dateStr = XmlUtil.getNodeText(node);
			String url = XmlUtil.getNodeText(node.getAttributes().getNamedItem("value"));
			AvailableNewsDate availableNewsDate = new AvailableNewsDate();
			availableNewsDate.setDateStr(dateStr);
			Date postDate = DateUtil.parseTruncateDate(dateStr, "yyyy/MM/dd");
			availableNewsDate.setPostDate(postDate);
			availableNewsDate.setUrl(url);
			availNewsDateList.add(availableNewsDate);
		}
		return availNewsDateList;
	}
	
	public Date getPostDate(String xml){
		Node node = XmlUtil.evaluateXpath(xml, "/html/body/div/div[4]/div[1]/div[2]/select/option", "selected", "selected");
		String nodeStr =  XmlUtil.getNodeText(node);
		return DateUtil.parseTruncateDate(nodeStr, "yyyy/MM/dd");
	}
	
	
}
