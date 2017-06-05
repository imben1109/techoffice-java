package com.techoffice.oracle;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JType;
import com.techoffice.oracle.config.OracleConfig;
import com.techoffice.oracle.daogen.service.DaoGenService;
import com.techoffice.oracle.pojo.service.PojoService;
import com.techoffice.oracle.ppackage.service.PackageService;
import com.techoffice.oracle.servicegen.service.ServiceGenService;
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
	
	@Autowired
	private DaoGenService daoGenService;
	
	@Autowired
	private ServiceGenService serviceGenService;
	
	@Transactional()
	public void run() throws JClassAlreadyExistsException, IOException{
		String tableName = OracleConfig.getGeneratorTable();
		String packageName = OracleConfig.getGeneratorPackage();
		JDefinedClass pojoType = pojoService.generateJavaCode(packageName + ".entity", tableName);
		packageService.generatePackage(tableName);
		sqlMapService.generateSqlMap(tableName);
		JDefinedClass daoType = daoGenService.genDao(packageName + ".dao", tableName);
		JDefinedClass serviceType = serviceGenService.generate(packageName+".service", tableName, daoType, pojoType);
	}
	
	public static void main(String[] args) throws IOException, JClassAlreadyExistsException{
		Appl appl = context.getBean(Appl.class);
		appl.run();
	}
}
