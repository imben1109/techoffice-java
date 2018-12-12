package com.techoffice.base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techoffice.entity.base.BaseTable1;
import com.techoffice.service.impl.base.BaseTable1SericeImpl;

public class Appl {
	
	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	

}
