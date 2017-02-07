package com.techoffice.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.techoffice.example.dao.TestDao;

@Component
public class Appl {
	public static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	@Autowired
	private TestDao testDao;
	
	@Autowired
	private SimpleCacheManager simpleCacheManager;
	
	public void run(){
		System.out.println("Spring Cache Example");
		String firstOne = testDao.get();
		testDao.get();
		System.out.println("The Second one is retrieved from Cache. That is why not system print");
		testDao.put();
		System.out.println("The Update Cache Value: " + testDao.get() + " . The Original Value: " + firstOne);
	}
	
	public static void main(String[] args){
		Appl appl = context.getBean(Appl.class);
		appl.run();
		
	}
}
