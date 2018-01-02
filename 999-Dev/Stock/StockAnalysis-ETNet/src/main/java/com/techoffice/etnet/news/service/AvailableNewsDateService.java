package com.techoffice.etnet.news.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.etnet.news.crawler.ImmediateNewsCrawler;
import com.techoffice.etnet.news.dao.AvailableNewsDateDao;
import com.techoffice.etnet.news.dao.NewsDao;
import com.techoffice.etnet.news.entity.AvailableNewsDate;
import com.techoffice.util.exception.TaskExecutorException;

@Service
public class AvailableNewsDateService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ImmediateNewsCrawler immediateNewsCrawler;
	
	@Autowired
	private AvailableNewsDateDao availableNewsDateDao;
	
	@Autowired
	private NewsDao newsDao;
	
	@Autowired
	private ImmediateNewsService immediateNewsService;
	
	@Transactional
	public void saveCrawledAvailableDateList(){
		 List<AvailableNewsDate> availableNewsDateList =  immediateNewsCrawler.getAvailableDateList();
		 for (AvailableNewsDate availableNewsDate: availableNewsDateList){
			 if (availableNewsDateDao.find(availableNewsDate.getPostDate()) == null){
				 availableNewsDateDao.add(availableNewsDate);
			 }
		 }
	}
	
	@Transactional
	public void saveCrawledImmediateNewsListWithNotRunAvailableDate(){
		List<Future<String>> futureList = new ArrayList<Future<String>>();
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		List<AvailableNewsDate> availableNewsDateList = availableNewsDateDao.listNotRun();
		log.info("Count: " + availableNewsDateList.size());
		for (final AvailableNewsDate availableNewsDate: availableNewsDateList){
			Future<String> future = executorService.submit(new Callable<String>(){
				public String call() {
					immediateNewsService.saveCrawledImmediateNewsListNewPropagation(availableNewsDate);
					return "completed";
				}
			});
			futureList.add(future);
		}
		for(Future<String> future: futureList){
			try {
				future.get();
			} catch (Exception e) {
				throw new TaskExecutorException(e);
			}
		}
	}
}
