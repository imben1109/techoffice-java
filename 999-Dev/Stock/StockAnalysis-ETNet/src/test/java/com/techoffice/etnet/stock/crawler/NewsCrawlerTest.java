package com.techoffice.etnet.stock.crawler;

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
public class NewsCrawlerTest {

	@Autowired
	private NewsCrawler newsCrawler;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void getNewsList(){
		List<String> newsList = newsCrawler.getNewsList();
		Assert.notEmpty(newsList);
		for (String news: newsList){
			log.info(news);
		}
	}
	
	@Test
	public void getNewsListStatic(){
		List<String> newsList = newsCrawler.getNewsList();
		newsList = SpecialStringUtil.replaceNonWordCharacter(newsList);
		Assert.notEmpty(newsList);
		Map<String, Integer> occurrenceMap = StringUtil.getOccurrenceMap(newsList);
		for (Map.Entry<String, Integer> entry: occurrenceMap.entrySet()){
			log.info(entry.getKey() + " " + entry.getValue());
		}
	}
	
}
