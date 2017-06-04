package com.techoffice.oracle;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.techoffice.oracle.config.OracleConfig;
import com.techoffice.oracle.pojo.service.PojoService;
import com.techoffice.oracle.ppackage.service.PackageService;
import com.techoffice.oracle.sqlmap.service.SqlMapService;


@Component
public class Appl {

	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	
	@Autowired
	private PojoService pojoService;
	
	@Autowired
	private PackageService packageService;
	
	@Autowired
	private SqlMapService sqlMapService;
	
	@Transactional()
	public void run() throws JClassAlreadyExistsException, IOException{
		String tableName = OracleConfig.getGeneratorTable();
		String packageName = OracleConfig.getGeneratorPackage();
//		pojoService.generateJavaCode(packageName, tableName);
//		packageService.generatePackage(tableName);
		sqlMapService.generateSqlMap(tableName);
	}
	
	public static void main(String[] args) throws IOException, JClassAlreadyExistsException{
		Appl appl = context.getBean(Appl.class);
		appl.run();
	}
}
