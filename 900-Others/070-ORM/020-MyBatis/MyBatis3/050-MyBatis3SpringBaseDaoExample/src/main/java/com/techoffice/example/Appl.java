package com.techoffice.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Appl {
	
	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	
	@Autowired
	private Table1Dao table1Dao;
	
	public void test(){
		table1Dao.createTable1();
		System.out.println(table1Dao.select().size());
		Table1 table1 = new Table1();
		table1.setCol1("test 1");
		table1Dao.insert(table1);
		System.out.println(table1Dao.select().size());
	}
	
	public static void main(String[] args) {
		Appl appl = context.getBean(Appl.class);
		appl.test();
	}
}
