package com.techoffice.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.techoffice.dao.base.BaseTable1Dao;

@Component
public class Appl {
	
	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	@Autowired
	private BaseTable1Dao table1Dao;
	
	public void test(){
		System.out.println(table1Dao.select().size());
	}
	
	public static void main(String[] args) {
		Appl appl = context.getBean(Appl.class);
		appl.test();
	}
}
