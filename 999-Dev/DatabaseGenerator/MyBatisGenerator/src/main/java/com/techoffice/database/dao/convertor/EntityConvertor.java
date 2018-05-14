package com.techoffice.database.dao.convertor;

import com.techoffice.database.dao.config.BaseConfig;
import com.techoffice.database.dao.model.Entity;
import com.techoffice.database.dao.util.StringUtil;

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
