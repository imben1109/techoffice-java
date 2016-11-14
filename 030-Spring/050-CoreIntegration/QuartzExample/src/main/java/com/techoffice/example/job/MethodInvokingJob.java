package com.techoffice.example.job;

/**
 * It is a Quartz Job. 
 * It would be instantiated with the method jobMethod by MethodInvokingJobDetailFactoryBean in Spring Context. 
 */
public class MethodInvokingJob {
	
	public void jobMethod(){
		System.out.println("Run MethodInvokingJob jobMethod");
	}
	
}
