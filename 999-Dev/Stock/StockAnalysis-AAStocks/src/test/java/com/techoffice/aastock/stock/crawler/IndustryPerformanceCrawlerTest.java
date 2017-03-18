package com.techoffice.aastock.stock.crawler;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techoffice.aastock.stock.model.Industry;
import com.techoffice.util.exception.WebCrawlerException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class IndustryPerformanceCrawlerTest {
	
	@Autowired
	private IndustryCrawler industryPerformanceCrawler;
	
	@Test
	public void getIndrustryList() throws WebCrawlerException {
		List<Industry> industryList = industryPerformanceCrawler.retrieveIndustryList();
		for(Industry industry: industryList){
			System.out.println(industry.getName());
		}
	}
}
