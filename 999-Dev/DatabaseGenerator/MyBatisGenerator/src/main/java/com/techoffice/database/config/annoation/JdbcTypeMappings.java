package com.techoffice.database.config.annoation;

public @interface JdbcTypeMappings {

	String value();
	String javaType();
	String javaFullType();
	String condition();
	
}
