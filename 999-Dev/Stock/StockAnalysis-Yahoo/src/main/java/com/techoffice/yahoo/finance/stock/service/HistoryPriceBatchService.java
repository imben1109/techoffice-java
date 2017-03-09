package com.techoffice.yahoo.finance.stock.service;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class HistoryPriceBatchService {

	@Autowired
	private SimpleJobLauncher simpleJobLauncher;
	
	@Autowired
	@Qualifier("updateHistoryPriceJob")
	private Job updateHistoryPriceJob;

	public void run() {
		try{
			JobExecution execution = simpleJobLauncher.run(updateHistoryPriceJob, new JobParameters());
			List<Throwable> exceptionList = execution.getAllFailureExceptions();
			for (Throwable exception: exceptionList){
				System.out.println(exception.getMessage());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
