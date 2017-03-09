package com.techoffice.jc.horse.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class DrawAccelerateTimeDaoTest {
	
	@Autowired
	private DrawAccelerateTimeDao drawAccelerateTimeDao;
	
	@Test
	public void getDrawAccelerateTime(){
		drawAccelerateTimeDao.getDrawAccelerateTime("Tin", "TURF - \"C+3\" COURSE", "1400M");
	}
	
}
