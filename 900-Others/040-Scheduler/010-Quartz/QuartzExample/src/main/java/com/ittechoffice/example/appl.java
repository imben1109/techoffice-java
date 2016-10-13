package com.ittechoffice.example;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class appl {
	public static void main(String[] args) throws SchedulerException{

		// Define a Job
		JobDetail job = JobBuilder.newJob(SimpleQuartzJob.class)
			    .withIdentity("simpleQuartzJob1", "simpleQuartzJob")
			    .build();
		
		// Define a trigger
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("simpleQuartzJobTrigger", "simpleQuartzJob")
				.withSchedule(
					SimpleScheduleBuilder.simpleSchedule()
						.withIntervalInSeconds(1).repeatForever())
				.build();
		
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);
		
	}
}
