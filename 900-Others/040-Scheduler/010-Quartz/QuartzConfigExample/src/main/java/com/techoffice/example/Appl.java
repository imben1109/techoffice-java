package com.techoffice.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class Appl {
	public static void main(String[] args) throws SchedulerException, IOException{

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
		
		// Load Quartz config from quartz.properties
        Properties prop = new Properties();
		InputStream is = Appl.class.getClassLoader().getResourceAsStream("quartz.properties");
		prop.load(is);
		SchedulerFactory schedulerFactory = new StdSchedulerFactory(prop);
		
		Scheduler scheduler = schedulerFactory.getScheduler();
		
		scheduler.start();
		scheduler.scheduleJob(job, trigger);

	}
}
