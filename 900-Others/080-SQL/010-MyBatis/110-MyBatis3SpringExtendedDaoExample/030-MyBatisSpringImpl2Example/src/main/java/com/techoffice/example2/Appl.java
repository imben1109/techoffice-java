package com.techoffice.example2;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techoffice.example2.dao.Table1Dao;
import com.techoffice.example2.entity.Table1;


public class Appl {
	
	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	public static void main(String[] args) {
		Table1Dao tester = context.getBean(Table1Dao.class);
		List<Table1> tableList = tester.select();
		System.out.println(tableList.get(0));
	}
}
