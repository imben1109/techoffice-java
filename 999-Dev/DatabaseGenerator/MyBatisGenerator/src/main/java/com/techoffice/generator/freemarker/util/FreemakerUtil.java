package com.techoffice.generator.freemarker.util;

import java.io.StringWriter;
import java.io.Writer;

import com.sun.xml.internal.ws.util.StringUtils;
import com.techoffice.generator.freemarker.exception.FreemakerException;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class FreemakerUtil {

	public static Configuration getConfiguration(){
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_25);
        configuration.setClassLoaderForTemplateLoading(FreemakerUtil.class.getClassLoader(), "/");
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);
        return configuration;
	}
	
	public static String generate(String templateName, Object dataModel){
		Template template = null;
		try {
        	Configuration configuration = getConfiguration();
			template = configuration.getTemplate(templateName);
		} catch (Exception e) {
			throw new FreemakerException("Failed to retrieve template: " + templateName, e);
		}
		
		try {
			Writer out = new StringWriter();
	        template.process(dataModel, out);
	        return out.toString();	
		}catch (Exception e) {
			throw new FreemakerException("Failed to process template: " + templateName, e);
		}
        
	}
	
	public static String getGeneratorTemplate(Class<?> clazz){
		String className = clazz.getSimpleName();
		String packageName = clazz.getPackage().getName();
		String path = packageName.replace(".", "/");
		String templateFileName = StringUtils.decapitalize(className);
		if (templateFileName.endsWith("Generator")){
			templateFileName = templateFileName.substring(0, templateFileName.length() - "Generator".length());
		}
		String templateName = path + "/template/" + templateFileName + ".ftlh";
		return templateName;
	}
	
	public static String generate(Class<?> clazz, Object dataModel){
		String templateName = FreemakerUtil.getGeneratorTemplate(clazz);
		return FreemakerUtil.generate(templateName, dataModel);
	}
	
}
