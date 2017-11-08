package com.techoffice.oracle.javamodel.service;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sun.codemodel.JClassAlreadyExistsException;
import com.techoffice.oracle.pojo.service.PojoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class PojoServiceTest {
	
	@Autowired
	private PojoService pojoService;
	
	@Test
	public void generate() throws JClassAlreadyExistsException, IOException{
		pojoService.generateJavaCode("", "TEST");
	}
}
