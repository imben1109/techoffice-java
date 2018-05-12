package com.techoffice.database.convertor;

import com.techoffice.database.model.Field;
import com.techoffice.mybatis.generator.config.SqlMapperMappingConfig;
import com.techoffice.mybatis.generator.config.annotation.SqlMapperMapping;

public class JdbcTypeConvertor {

	private JdbcTypeConvertor(){}
	
	public static Field convert(Field field){
		String jdbcType = field.getJdbcType();
		SqlMapperMapping jdbcTypeMapping = SqlMapperMappingConfig.getSqlMapperMapping(jdbcType);
		jdbcTypeMapping.javaType();
		return field;
	}
}
