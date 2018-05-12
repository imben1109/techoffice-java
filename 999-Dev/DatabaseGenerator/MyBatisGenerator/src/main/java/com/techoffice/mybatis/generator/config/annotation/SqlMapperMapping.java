package com.techoffice.mybatis.generator.config.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SqlMapperMapping {

	String value();
	String jdbcType();
	String javaType(); 
}
