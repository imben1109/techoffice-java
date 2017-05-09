package com.techoffice.yahoo.finance.stock.service;

import java.util.Date;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PriceBatchService {

	@Autowired
	private SimpleJobLauncher simpleAsyncJobLauncher;
	
	@Autowired
	@Qualifier("updateHistoryPriceJob")
	private Job updateHistoryPriceJob;

	public void run() {
		try{
			JobParameters paramerter = new JobParametersBuilder().addDate("date", new Date()).toJobParameters();
			simpleAsyncJobLauncher.run(updateHistoryPriceJob, paramerter);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
