package com.techoffice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.techoffice.dao.Table1Dao;
import com.techoffice.model.Table1;

@Component
public class Appl {
	
	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	@Autowired
	private Table1Dao table1Dao;
	
	public void test(){
		List<Table1> list = table1Dao.select();
		for (Table1 t: list){
			System.out.println(t.getCol1());
		}
	}
	
	public static void main(String[] args) {
		Appl appl = context.getBean(Appl.class);
		appl.test();
	}
}
