package com.techoffice.aastock.stock.service;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.aastock.stock.dao.JobDao;
import com.techoffice.aastock.stock.exception.JobException;
import com.techoffice.aastock.stock.model.Job;
import com.techoffice.aastock.stock.model.JobTask;

@Service
public class JobService {

	@Autowired
	private JobDao jobDao;
	
	@Transactional
	private void lockJob(List<Object> objList, String taskField) throws JobException{
		if (objList.size() > 0){
			Object firstObj = objList.get(0);
			String className = firstObj.getClass().getName();
			Job job = new Job();
			job.setClassName(className);
			jobDao.add(job);
			for (Object obj: objList){
				try {
					String taskName = BeanUtils.getProperty(obj, taskField);
					JobTask jobTask = new JobTask();
					jobTask.setTaskName(taskName);
					jobTask.setJobId(job.getId());
				} catch (Exception e) {
					throw new JobException("Fail to extract " + taskField + " from " +  firstObj.getClass().getName(), e);
				}
			}
		}
	}
}
