package com.techoffice.generator.mapping.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)  
public @interface ClassType {

	String classType();
	String dataType();
	int precision() default 0;
	int scale() default 0;
	
}
