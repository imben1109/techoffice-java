package com.ittechoffice.example;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SimpleQuartzJob implements Job{

	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("running SimpleQuartzJob");
	}
	
}
