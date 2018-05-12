package com.techoffice.database.convertor;

import com.techoffice.database.config.annoation.JdcbTypeMapping;
import com.techoffice.database.config.annoation.JdbcTypeMappings;

@JdbcTypeMappings(
	value={
		@JdcbTypeMapping(value="VARCHAR2", jdbcType="VARCHAR",  javaType="string"),
		@JdcbTypeMapping(value="NUMBER", jdbcType="NUMERIC",  javaType="java.math.BigDecimal"),
		@JdcbTypeMapping(value="DATE", jdbcType="DATE", javaType="date")
	}, 
	exceptionFields={
		@JdcbTypeMapping(value="lvCde", jdbcType="VARCHAR", javaType="string"),
		@JdcbTypeMapping(value="applCde", jdbcType="VARCHAR", javaType="string"),
		@JdcbTypeMapping(value="officCde", jdbcType="NUMERIC", javaType="double")
	}
)
public class JdbcTypeMappingConvertor {

	public static JdbcTypeMappings getSqlMapperMappings(){
		JdbcTypeMappings sqlMapperMappings = JdbcTypeMappingConvertor.class.getAnnotation(JdbcTypeMappings.class);
		return sqlMapperMappings;
	}
	
	public static JdcbTypeMapping[] getSqlMapperMappingArr(){
		JdbcTypeMappings sqlMapperMappings = getSqlMapperMappings();
		return sqlMapperMappings.value();
	}
	
	public static JdcbTypeMapping getSqlMapperMapping(String value){
		JdcbTypeMapping[] sqlMapperMappingArr = getSqlMapperMappingArr();
		for (int i=0; i<sqlMapperMappingArr.length; i++){
			JdcbTypeMapping sqlMapperMapping = sqlMapperMappingArr[i];
			if (sqlMapperMapping.value().equals(value)){
				return sqlMapperMapping;
			}
		}
		return null;
	}
	
	public static JdcbTypeMapping[] getExceptionSqlMapperMappingArr(){
		return getSqlMapperMappings().exceptionFields();
	}
	
	public static JdcbTypeMapping getExceptionSqlMapperMapping(String value){
		JdcbTypeMapping[] sqlMapperMappingArr = getExceptionSqlMapperMappingArr();
		for (int i=0; i<sqlMapperMappingArr.length; i++){
			JdcbTypeMapping sqlMapperMapping = sqlMapperMappingArr[i];
			if (sqlMapperMapping.value().equals(value)){
				return sqlMapperMapping;
			}
		}
		return null;
	}
}
