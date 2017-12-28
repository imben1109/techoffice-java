package com.techoffice.aastock.stock.crawler;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class EarningSummaryCrawlerTest {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EarningSummaryCrawler earningSummaryCrawler;
	
	@Test
	public void getYearList() {
		 List<String> yearList = earningSummaryCrawler.getYearList("00010");
		 for (String year: yearList){
			 log.info(year);
		 }
	}
	
	@Test
	public void getEarningPerShare() {
		List<String> earningPerShareList = earningSummaryCrawler.getEarningPerShare("00010");
		for (String earningPerShare: earningPerShareList){
			log.info(earningPerShare);
		}
	}
	
	@Test
	public void getDividendPerShare() {
		List<String> dividendPerShareList = earningSummaryCrawler.getDividendPerShare("00010");
		for (String dividendPerShare: dividendPerShareList){
			log.info(dividendPerShare);
		}
	}
	
	
}
