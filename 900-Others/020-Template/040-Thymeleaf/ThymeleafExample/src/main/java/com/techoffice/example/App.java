package com.techoffice.example;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.io.StringWriter;

public class App {

    private static ITemplateResolver textTemplateResolver() {
        final ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setOrder(Integer.valueOf(1));
        templateResolver.setPrefix("/template/");
        templateResolver.setSuffix(".txt");
        templateResolver.setTemplateMode(TemplateMode.TEXT);
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setCacheable(false);
        return templateResolver;
    }

    public static void main(String[] args){
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(textTemplateResolver());
        StringWriter writer = new StringWriter();
        Context context = new Context();
        context.setVariable("variable1", "World");
        templateEngine.process("test", context, writer);
        System.out.println(writer.toString());
    }

}
