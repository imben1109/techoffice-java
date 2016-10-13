package com.ittechoffice.example.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * It is a Quartz Job. 
 * It would be instantiated by JobDetailFactoryBean
 */
public class SimpleJob extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
		System.out.println("Run Simple Job");
	}

}
