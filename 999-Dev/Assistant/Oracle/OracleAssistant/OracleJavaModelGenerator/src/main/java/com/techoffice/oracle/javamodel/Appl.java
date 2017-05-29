package com.techoffice.oracle.javamodel;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.techoffice.oracle.javamodel.config.OracleConfig;
import com.techoffice.oracle.javamodel.service.PojoService;


@Component
public class Appl {

	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	
	@Autowired
	private PojoService pojoService;
	
	@Transactional()
	public void run() throws JClassAlreadyExistsException, IOException{
		String tableName = OracleConfig.getGeneratorTable();
		String packageName = OracleConfig.getGeneratorPackage();
		pojoService.generate(packageName, tableName);
	}
	
	public static void main(String[] args) throws IOException, JClassAlreadyExistsException{
		Appl appl = context.getBean(Appl.class);
		appl.run();
	}
}
