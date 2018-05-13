package com.techoffice.database.config;

import com.techoffice.database.config.annoation.JdbcTypeMapping;
import com.techoffice.database.config.annoation.JdbcTypeMappings;

@JdbcTypeMappings({
	@JdbcTypeMapping(value = "NUMBER", javaFullType = "java.lang.Integer", condition = "field.scale == 0"),
	@JdbcTypeMapping(value = "NUMBER", javaFullType = "java.math.BigDecimal", condition="field.scale != 0"),
	@JdbcTypeMapping(value = "VARCHAR2", javaFullType="java.lang.String"),
	@JdbcTypeMapping(value = "DATE", javaFullType = "java.util.Date")
})
public class JdbcTypeConfig {

	private JdbcTypeConfig(){}
	
	public static JdbcTypeMappings getJdbcTypeMappings(){
		return JdbcTypeConfig .class.getAnnotation(JdbcTypeMappings.class);
	}
	
	public static JdbcTypeMapping[] getJdbcTypeMappingArr(){
		JdbcTypeMappings jdbcTypeMappings = getJdbcTypeMappings();
		return jdbcTypeMappings.value();
	}
	
	public static JdbcTypeMapping getJdbcTypeMapping(String value){
		JdbcTypeMapping[] jdbcTypeMappingArr = getJdbcTypeMappingArr();
		for (int i=0; i<jdbcTypeMappingArr.length; i++){
			JdbcTypeMapping jdbcTypeMapping = jdbcTypeMappingArr[i];
			if (jdbcTypeMapping.value() == value ){
				return jdbcTypeMapping;
			}
		}
		return null;
	}
}
