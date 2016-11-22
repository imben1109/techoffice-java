package com.techoffice.example;

import java.util.List;
import java.util.Set;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Appl {
	
	@Autowired
	private Scheduler scheduler;
	
	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	public void run() throws SchedulerException{
		System.out.println("Spring Quartz Example");
		List<String> groups = scheduler.getJobGroupNames();
		for (String group: groups){
			Set<JobKey> jobKeySet = scheduler.getJobKeys(GroupMatcher.jobGroupEquals(group));
			for(JobKey jobKey: jobKeySet){
				List<Trigger> triggerList = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
				System.out.println("Group Id: " + jobKey.getGroup() + " and Job Id: " + jobKey.getName());
				System.out.println("=================================");
				for (Trigger trigger: triggerList){
					System.out.println("Next Fire Time: " + trigger.getNextFireTime());
				}
			}
		}
		System.out.println("=================END=================");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
	public static void main(String[] args) throws SchedulerException{
		Appl appl = context.getBean(Appl.class);
		appl.run();
	}
}
