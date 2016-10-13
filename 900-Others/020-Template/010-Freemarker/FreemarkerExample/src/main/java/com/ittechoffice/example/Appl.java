package com.ittechoffice.example;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class Appl {
	public static void main(String[] args) throws URISyntaxException, IOException, TemplateException{
		String home = Paths.get(Appl.class.getClassLoader().getResource(".").toURI()).getParent().getParent().toString();
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
        cfg.setDirectoryForTemplateLoading(new File(home + "/Template"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        Template temp = cfg.getTemplate("template.ftlh");
        Writer out = new OutputStreamWriter(System.out);
        Map<String, Object> map = new HashMap<String, Object>();
        User user = new User();
        user.setName("Test Name");
        map.put("user", user);
        temp.process(map, out);

	}
}
