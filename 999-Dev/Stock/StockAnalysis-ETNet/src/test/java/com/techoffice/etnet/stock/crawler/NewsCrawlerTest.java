package com.techoffice.etnet.stock.crawler;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.techoffice.etnet.news.crawler.ImmediateNewsCrawler;
import com.techoffice.etnet.news.entity.News;
import com.techoffice.etnet.news.model.AvailableNewsDate;
import com.techoffice.util.ListUtil;
import com.techoffice.util.SpecialStringUtil;
import com.techoffice.util.StringUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class NewsCrawlerTest {

	@Autowired
	private ImmediateNewsCrawler newsCrawler;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void getNewsList(){
		List<News> newsList = newsCrawler.getNewsList();
		Assert.notEmpty(newsList);
		for (News news: newsList){
			log.info(news.getContents());
		}
	}
	
	@Test
	public void getNewsListStatic(){
		List<News> crawledNewsList = newsCrawler.getNewsList();
		List<String> newsList = ListUtil.getAttributeList(crawledNewsList, "content");
		newsList = SpecialStringUtil.replaceNonWordCharacter(newsList);
		Assert.notEmpty(newsList);
		Map<String, Integer> occurrenceMap = StringUtil.getOccurrenceMap(newsList);
		for (Map.Entry<String, Integer> entry: occurrenceMap.entrySet()){
			log.info(entry.getKey() + " " + entry.getValue());
		}
	}
	
	@Test
	public void getAvailableDateList(){
		List<AvailableNewsDate> availableDateList = newsCrawler.getAvailableDateList();
		Assert.notEmpty(availableDateList);
		for (AvailableNewsDate availableDate: availableDateList){
			log.info(availableDate.getUrl());
		}
	}
	
	@Test
	public void getPostDate(){
		Date postDate = newsCrawler.getPostDate(newsCrawler.getXml());
		log.info(postDate.toString());
	}
}
