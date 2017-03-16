package com.techoffice.example.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@EnableAutoConfiguration
@EnableBatchProcessing
@ImportResource("classpath:beans.xml")
public class Config {

}
