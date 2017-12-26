package com.techoffice.hkex.stock.batch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techoffice.yahoo.finance.stock.exception.PriceBatchJobException;
import com.techoffice.yahoo.finance.stock.service.PriceBatchService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class PriceBatchServiceTest {
	
	@Autowired
	private PriceBatchService priceBatchService;

	@Test
	public void run() throws PriceBatchJobException{
		priceBatchService.run();
	}

}
