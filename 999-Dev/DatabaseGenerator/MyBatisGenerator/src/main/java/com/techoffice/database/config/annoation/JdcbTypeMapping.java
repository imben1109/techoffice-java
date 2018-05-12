package com.techoffice.database.config.annoation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface JdcbTypeMapping {

	String value();
	String jdbcType();
	String javaType(); 
}
