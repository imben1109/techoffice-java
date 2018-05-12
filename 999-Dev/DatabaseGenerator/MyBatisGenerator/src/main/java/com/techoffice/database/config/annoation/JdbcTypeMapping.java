package com.techoffice.database.config.annoation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface JdbcTypeMapping {

	String value();
	String jdbcType();
	String javaType(); 
}
