package com.techoffice.database.config;

import com.techoffice.database.config.annoation.JdbcTypeMapping;
import com.techoffice.database.config.annoation.JdbcTypeMappings;

@JdbcTypeMappings({
	@JdbcTypeMapping(value = "NUMBER", 	javaType = "Integer", javaFullType = "java.lang.Integer", condition = "scale == 0"),
	@JdbcTypeMapping(value = "VARCHAR2", javaType="String", javaFullType="java.lang.String")
})
public class JdbcTypeConfig {

}
