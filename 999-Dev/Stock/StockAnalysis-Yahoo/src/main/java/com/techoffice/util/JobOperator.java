package com.techoffice.util;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.ListableJobLocator;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobExecutionNotRunningException;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.launch.NoSuchJobExecutionException;
import org.springframework.batch.core.launch.support.SimpleJobOperator;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.StepSynchronizationManager;
import org.springframework.batch.core.step.NoSuchStepException;
import org.springframework.batch.core.step.StepLocator;
import org.springframework.batch.core.step.tasklet.StoppableTasklet;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.transaction.annotation.Transactional;

public class JobOperator extends SimpleJobOperator {
	
	private JobExplorer jobExplorer;
	
	private JobRepository jobRepository;
	
	private ListableJobLocator jobRegistry;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	@Transactional
	public boolean stop(long executionId) throws NoSuchJobExecutionException, JobExecutionNotRunningException {
		JobExecution jobExecution = findExecutionById(executionId);
		jobExecution.setStatus(BatchStatus.STOPPING);
		jobExecution.setEndTime(new Date());
		jobRepository.update(jobExecution);
	
		try {
			Job job = jobRegistry.getJob(jobExecution.getJobInstance().getJobName());
			if (job instanceof StepLocator) {//can only process as StepLocator is the only way to get the step object
				//get the current stepExecution
				for (StepExecution stepExecution : jobExecution.getStepExecutions()) {
					if (stepExecution.getStatus().isRunning()) {
						try {
							//have the step execution that's running -> need to 'stop' it
							Step step = ((StepLocator)job).getStep(stepExecution.getStepName());
							if (step instanceof TaskletStep) {
								Tasklet tasklet = ((TaskletStep)step).getTasklet();
								if (tasklet instanceof StoppableTasklet) {
									StepSynchronizationManager.register(stepExecution);
									((StoppableTasklet)tasklet).stop();
									StepSynchronizationManager.release();
								}
							}
						}
						catch (NoSuchStepException e) {
							log.warn("Step not found",e);
						}
					}
				}
			}
		}
		catch (NoSuchJobException e) {
			log.warn("Cannot find Job object",e);
		}

		log.info("Execution [id:" + executionId +  "] is stopped");
		return true;
	}
	
	@Override
	public void setJobRegistry(ListableJobLocator jobRegistry) {
		super.setJobRegistry(jobRegistry);
		this.jobRegistry = jobRegistry;
	}
	
	@Override
	public void setJobExplorer(JobExplorer jobExplorer) {
		super.setJobExplorer(jobExplorer);
		this.jobExplorer = jobExplorer;
	}

	@Override
	public void setJobRepository(JobRepository jobRepository) {
		super.setJobRepository(jobRepository);
		this.jobRepository = jobRepository;
	}

	
	private JobExecution findExecutionById(long executionId) throws NoSuchJobExecutionException {
		JobExecution jobExecution = jobExplorer.getJobExecution(executionId);

		if (jobExecution == null) {
			throw new NoSuchJobExecutionException("No JobExecution found for id: [" + executionId + "]");
		}
		return jobExecution;

	}
	

}
