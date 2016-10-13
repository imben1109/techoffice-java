# Quartz Example

Home Page: http://www.quartz-scheduler.org/

It is a job scheduling library.

### Components
* Job
* Trigger

Job define what would be executed.
Trigger define when would be executed

Define a Job
```
JobDetail job = JobBuilder.newJob(SimpleQuartzJob.class)
	    .withIdentity("simpleQuartzJob1", "simpleQuartzJob")
	    .build();
```

Define a Trigger
```
Trigger trigger = TriggerBuilder
		.newTrigger()
		.withIdentity("simpleQuartzJobTrigger", "simpleQuartzJob")
		.withSchedule(
			SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(1).repeatForever())
		.build();
```

Then, Quartz Scheduler would execute the job according to the schedule specified in Trigger.
```
SchedulerFactory schedulerFactory = new StdSchedulerFactory();
Scheduler scheduler = schedulerFactory.getScheduler();
scheduler.start();
scheduler.scheduleJob(job, trigger);
```




