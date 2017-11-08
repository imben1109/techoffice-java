package com.techoffice.oracle.servicegen.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JType;
import com.techoffice.oracle.servicegen.generator.ServiceGenGenerator;

@Service
public class ServiceGenService {
	
	public JDefinedClass generate(String packageName, String className, JDefinedClass daoType, JDefinedClass pojoType) throws JClassAlreadyExistsException, IOException{
		ServiceGenGenerator serviceGenGenerator = new ServiceGenGenerator(packageName, className, daoType, pojoType);
		File file = new File("Java");
		return serviceGenGenerator.generateCode(file);
	}
}
