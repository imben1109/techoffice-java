package com.techoffice.generator.mapping.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) 
public @interface DataTypeMappings {

	DataTypeMapping[] value();
}
