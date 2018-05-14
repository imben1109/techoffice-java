package com.techoffice.database.convertor;

import com.techoffice.database.config.BaseConfig;
import com.techoffice.database.model.Entity;
import com.techoffice.mybatis.generator.util.StringUtil;

public class EntityConvertor {

	private EntityConvertor(){}
	
	public static Entity convert(Entity entity){
		String javaClassName = StringUtil.upperUnderscoreToUpperCamel(entity.getTableName());
		entity.setJavaClassName(javaClassName);
		String basePackage = BaseConfig.getBasePackage();
		entity.setBasePackage(basePackage);

		return entity;
	}
	
}
