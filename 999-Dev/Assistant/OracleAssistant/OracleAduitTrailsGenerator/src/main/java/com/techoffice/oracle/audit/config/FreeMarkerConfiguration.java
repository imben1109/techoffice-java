package com.techoffice.oracle.audit.config;

import java.io.File;
import java.io.IOException;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

public class FreeMarkerConfiguration extends Configuration{
	public FreeMarkerConfiguration() throws IOException{
		super(Configuration.VERSION_2_3_25);
        this.setDirectoryForTemplateLoading(new File(FreeMarkerConfiguration.class.getClassLoader().getResource("Template").getPath()));
        this.setDefaultEncoding("UTF-8");
        this.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        this.setLogTemplateExceptions(false);
	}
}
