package com.techoffice.database.config.annoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface JdbcTypeMapping {
	
	String value();
	String javaType();
	String javaFullType();
	String condition() default "";;
	
}
