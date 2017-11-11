package com.techoffice.jc.horse.crawler;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techoffice.jc.horse.dao.HorseAdjTimeDao;
import com.techoffice.jc.horse.dto.CurrentOdd;
import com.techoffice.jc.horse.test.util.JunitAssertUtil;
import com.techoffice.util.BeanUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class CurrentOddCrawlerTest {
	
	@Autowired
	private CurrentOddCrawler currentOddCrawler;
	
	@Autowired
	private HorseAdjTimeDao horseAdjTimeDao;
	
	@Test
	public void getRaceNums() {
		currentOddCrawler.getRaceNums();		
	}
	
	@Test
	public void getHorse() {
		List<CurrentOdd> currentOddList = currentOddCrawler.getCurrentOdd();
		for(CurrentOdd currentOdd: currentOddList){
			System.out.println(BeanUtil.toString(currentOdd));
			JunitAssertUtil.assertAllPropertyNotNull(currentOdd);
		}
	}
	
	@Test
	public void run() {
		currentOddCrawler.run();
	}
}
