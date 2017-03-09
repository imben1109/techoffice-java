package com.techoffice.oracle.audit;


import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.oracle.audit.config.ApplConfig;
import com.techoffice.oracle.audit.generator.CreateAuditTableScriptGenerator;
import com.techoffice.oracle.audit.generator.CreateAuditTriggerScriptGenerator;

import freemarker.template.TemplateException;


@Component
public class Appl {

	static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	
	@Autowired
	private CreateAuditTriggerScriptGenerator createAuditTriggerScriptGenerator;
	
	@Autowired
	private CreateAuditTableScriptGenerator createAuditTableScriptGenerator;
	
	@Transactional()
	public void run() throws URISyntaxException, IOException, TemplateException{
		createAuditTableScriptGenerator.generate();
		createAuditTriggerScriptGenerator.generate();
	}
	
	public static void main(String[] args) throws URISyntaxException, IOException, TemplateException{
		Appl appl = context.getBean(Appl.class);
		appl.run();
	}
}
