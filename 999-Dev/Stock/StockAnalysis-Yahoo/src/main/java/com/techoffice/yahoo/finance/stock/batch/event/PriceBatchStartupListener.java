package com.techoffice.yahoo.finance.stock.batch.event;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobExecutionNotRunningException;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.launch.NoSuchJobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Price Batch Startup Listener
 * 
 * @author imben1109
 *
 */
@Component
public class PriceBatchStartupListener {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	@Qualifier("updateHistoryPriceJob")
	private Job updateHistoryPriceJob;
	
	@Autowired
	private JobOperator jobOperator;
	
	/**
	 * Run the Spring Batch Job Operation to stop all job of Update History Price Job 
	 * when the Spring Context is refreshed. 
	 * 
	 * @throws NoSuchJobException 
	 * @throws JobExecutionNotRunningException 
	 * @throws NoSuchJobExecutionException 
	 */
	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() throws NoSuchJobException, NoSuchJobExecutionException, JobExecutionNotRunningException {
		log.info("Spring Context Refreshed");
		Set<Long> executionIds = jobOperator.getRunningExecutions(updateHistoryPriceJob.getName());
		for(Long executionId: executionIds){
			jobOperator.stop(executionId);
		}
	}
	
}
