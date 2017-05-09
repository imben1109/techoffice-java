package com.techoffice.util.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.repository.support.SimpleJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Job Explore Service for Spring Batch 
 * 
 * @author imben1109
 *
 */
@Service
public class JobExplorerService {
	
	@Autowired
	private JobExplorer jobExplorer;

	public List<String> getJobNames(){
		return jobExplorer.getJobNames();
	}
	
	public Map<String, String> getJobs(){
		Map<String, String> jobMap = new HashMap<String, String>();
		List<String> jobNames = jobExplorer.getJobNames();
		for (String jobName: jobNames){
			int jobCount = 0;
			try {
				jobCount = jobExplorer.getJobInstanceCount(jobName);
			} catch (NoSuchJobException e) {
				e.printStackTrace();
				jobCount = 0;
			}
			jobMap.put(jobName, Integer.toString(jobCount));
		}
		return jobMap;
	}
	
	public boolean isJobRunning(String jobName){
		
		int jobCount = 0;
		try {
			jobCount = jobExplorer.getJobInstanceCount(jobName);
		} catch (NoSuchJobException e) {
			jobCount = 0;
		}
		List<JobInstance> jobInstances = jobExplorer.getJobInstances(jobName, 0, jobCount);
		for(JobInstance jobInstance: jobInstances){
			List<JobExecution> jobExecutions = jobExplorer.getJobExecutions(jobInstance);
			for (JobExecution jobExecution: jobExecutions){
				if (jobExecution.isRunning()){
					return true;
				}
			}
		}
		return false;
	}
	
}
