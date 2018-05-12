package com.techoffice.database.config;

import com.techoffice.database.config.annoation.JdbcTypeMapping;
import com.techoffice.database.config.annoation.JdbcTypeMappings;

@JdbcTypeMappings(
	value={
		@JdbcTypeMapping(value="VARCHAR2", jdbcType="VARCHAR",  javaType="string"),
		@JdbcTypeMapping(value="NUMBER", jdbcType="NUMERIC",  javaType="java.math.BigDecimal"),
		@JdbcTypeMapping(value="DATE", jdbcType="DATE", javaType="date")
	}
)
public class JdbcTypeMappingConfig {

	public static JdbcTypeMappings getJdbcTypeMappings(){
		JdbcTypeMappings sqlMapperMappings = JdbcTypeMappingConfig.class.getAnnotation(JdbcTypeMappings.class);
		return sqlMapperMappings;
	}
	
	public static JdbcTypeMapping[] getJdbcTypeMappingArr(){
		JdbcTypeMappings sqlMapperMappings = getJdbcTypeMappings();
		return sqlMapperMappings.value();
	}
	
	public static JdbcTypeMapping getJdbcTypeMapping(String value){
		JdbcTypeMapping[] sqlMapperMappingArr = getJdbcTypeMappingArr();
		for (int i=0; i<sqlMapperMappingArr.length; i++){
			JdbcTypeMapping sqlMapperMapping = sqlMapperMappingArr[i];
			if (sqlMapperMapping.value().equals(value)){
				return sqlMapperMapping;
			}
		}
		return null;
	}
	
	public static JdbcTypeMapping[] getExceptionJdbcTypeMappingArr(){
		return getJdbcTypeMappings().exceptionFields();
	}
	
	public static JdbcTypeMapping getExceptionJdbcTypeMapping(String value){
		JdbcTypeMapping[] sqlMapperMappingArr = getExceptionJdbcTypeMappingArr();
		for (int i=0; i<sqlMapperMappingArr.length; i++){
			JdbcTypeMapping sqlMapperMapping = sqlMapperMappingArr[i];
			if (sqlMapperMapping.value().equals(value)){
				return sqlMapperMapping;
			}
		}
		return null;
	}
}
