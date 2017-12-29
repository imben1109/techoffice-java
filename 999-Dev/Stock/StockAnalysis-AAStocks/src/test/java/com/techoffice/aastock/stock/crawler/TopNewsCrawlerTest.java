package com.techoffice.aastock.stock.crawler;

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

import com.techoffice.util.SpecialStringUtil;
import com.techoffice.util.StringUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TopNewsCrawlerTest {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TopNewsCrawler topNewsCrawler;

	@Test
	public void getNewsList(){
		List<String> newsList = topNewsCrawler.getNewsList();
		Assert.notEmpty(newsList);
		for (String news: newsList){
			log.info(news);
		}
	}
	
	@Test
	public void newsKeyWordCount(){
		List<String> newsList = topNewsCrawler.getNewsList();
		Assert.notEmpty(newsList);
		newsList = SpecialStringUtil.replaceNonWordCharacter(newsList);
		Map<String, Integer> occurrenceMap = StringUtil.getOccurrenceMap(newsList);
		for (Map.Entry<String, Integer> entry :occurrenceMap.entrySet()){
			log.info(entry.getKey() + " " + entry.getValue());
		}
	}
}
