package com.techoffice.example.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableAutoConfiguration
@EnableBatchProcessing
@ImportResource("classpath:beans.xml")
public class Config extends WebMvcConfigurerAdapter{
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("WEB-INF/resources/js/");
        registry.addResourceHandler("/lib/**").addResourceLocations("WEB-INF/resources/lib/");
    }

}
