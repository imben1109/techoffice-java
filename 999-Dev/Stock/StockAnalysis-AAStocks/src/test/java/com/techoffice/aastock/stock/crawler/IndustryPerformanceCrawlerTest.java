package com.techoffice.aastock.stock.crawler;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.techoffice.aastock.stock.model.Industry;
import com.techoffice.util.exception.WebCrawlerException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class IndustryPerformanceCrawlerTest {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IndustryCrawler industryPerformanceCrawler;
	
	@Test
	public void getIndrustryList() throws WebCrawlerException {
		List<Industry> industryList = industryPerformanceCrawler.retrieveIndustryList();
		Assert.notEmpty(industryList);
		for(Industry industry: industryList){
			log.info(industry.getName());
		}
	}
}
