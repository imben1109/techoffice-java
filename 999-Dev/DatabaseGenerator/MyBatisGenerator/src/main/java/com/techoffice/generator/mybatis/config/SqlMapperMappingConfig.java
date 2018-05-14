package com.techoffice.generator.mybatis.config;

import com.techoffice.generator.mybatis.config.annotation.SqlMapperMapping;
import com.techoffice.generator.mybatis.config.annotation.SqlMapperMappings;

@SqlMapperMappings(
	value={
		@SqlMapperMapping(value="VARCHAR2", jdbcType="VARCHAR",  javaType="string"),
		@SqlMapperMapping(value="NUMBER", jdbcType="NUMERIC",  javaType="java.math.BigDecimal"),
		@SqlMapperMapping(value="DATE", jdbcType="DATE", javaType="date")
	}
)
public class SqlMapperMappingConfig {

	public static SqlMapperMappings getSqlMapperMappings(){
		SqlMapperMappings sqlMapperMappings = SqlMapperMappingConfig.class.getAnnotation(SqlMapperMappings.class);
		return sqlMapperMappings;
	}
	
	public static SqlMapperMapping[] getSqlMapperMappingArr(){
		SqlMapperMappings sqlMapperMappings = getSqlMapperMappings();
		return sqlMapperMappings.value();
	}
	
	public static SqlMapperMapping getSqlMapperMapping(String value){
		SqlMapperMapping[] sqlMapperMappingArr = getSqlMapperMappingArr();
		for (int i=0; i<sqlMapperMappingArr.length; i++){
			SqlMapperMapping sqlMapperMapping = sqlMapperMappingArr[i];
			if (sqlMapperMapping.value().equals(value)){
				return sqlMapperMapping;
			}
		}
		return null;
	}
	
	public static SqlMapperMapping[] getExceptionSqlMapperMappingArr(){
		return getSqlMapperMappings().exceptionFields();
	}
	
	public static SqlMapperMapping getExceptionSqlMapperMapping(String value){
		SqlMapperMapping[] sqlMapperMappingArr = getExceptionSqlMapperMappingArr();
		for (int i=0; i<sqlMapperMappingArr.length; i++){
			SqlMapperMapping sqlMapperMapping = sqlMapperMappingArr[i];
			if (sqlMapperMapping.value().equals(value)){
				return sqlMapperMapping;
			}
		}
		return null;
	}
}
