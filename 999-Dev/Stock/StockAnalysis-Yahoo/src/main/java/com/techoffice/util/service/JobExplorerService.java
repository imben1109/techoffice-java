package com.techoffice.util.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return false;
	}
	
	public Map<String, String> getJobsLastStatus(){
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
			List<JobInstance> jobInstanceList = jobExplorer.getJobInstances(jobName, jobCount - 1, 1);
			JobInstance lastJobInstance = jobInstanceList.get(0);
			List<JobExecution> jobExecutions = jobExplorer.getJobExecutions(lastJobInstance);
			JobExecution jobExecution = jobExecutions.get(jobExecutions.size() - 1);
			jobMap.put(jobName, Boolean.toString(jobExecution.isRunning()));
		}
		return jobMap;
	}
}
