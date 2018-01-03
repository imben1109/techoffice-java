package com.techoffice.example;

import java.util.List;

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
		List<Table1> temp3List = table1Dao.select();
		for(Table1 temp3: temp3List){
			System.out.println(temp3.getCol2());
		}
		System.out.println(table1Dao.select().size());
		Table1 table1 = new Table1();
		table1.setCol1("test 1");
		table1Dao.insert(table1);
		table1.setCol2("test 2");
		table1Dao.update(table1);
		System.out.println(table1Dao.select().size());
		List<Table1> temp2List = table1Dao.select();
		for(Table1 temp2: temp2List){
			System.out.println(temp2.getCol2());
		}
	}
	
	public static void main(String[] args) {
		Appl appl = context.getBean(Appl.class);
		appl.test();
	}
}
