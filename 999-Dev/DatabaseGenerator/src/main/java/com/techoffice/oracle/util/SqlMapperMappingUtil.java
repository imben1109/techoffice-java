package com.techoffice.oracle.util;

import com.techoffice.mybatis.config.annoation.SqlMapperMapping;
import com.techoffice.mybatis.config.annoation.SqlMapperMappings;

@SqlMapperMappings(
	value={
		@SqlMapperMapping(value="VARCHAR2", jdbcType="VARCHAR",  javaType="string"),
		@SqlMapperMapping(value="NUMBER", jdbcType="NUMERIC",  javaType="java.math.BigDecimal"),
		@SqlMapperMapping(value="DATE", jdbcType="DATE", javaType="date")
	}, 
	exceptionFields={
		@SqlMapperMapping(value="lvCde", jdbcType="VARCHAR", javaType="string"),
		@SqlMapperMapping(value="applCde", jdbcType="VARCHAR", javaType="string"),
		@SqlMapperMapping(value="officCde", jdbcType="NUMERIC", javaType="double")
	}
)
public class SqlMapperMappingUtil {

	public static SqlMapperMappings getSqlMapperMappings(){
		SqlMapperMappings sqlMapperMappings = SqlMapperMappingUtil.class.getAnnotation(SqlMapperMappings.class);
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
