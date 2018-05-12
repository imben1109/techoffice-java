package com.techoffice.database.convertor;

import com.techoffice.database.model.Entity;
import com.techoffice.util.StringUtil;

public class EntityConvertor {

	private EntityConvertor(){}
	
	public static Entity convert(Entity entity){
		String javaClassName = StringUtil.upperUnderscoreToUpperCamel(entity.getTableName());
		entity.setJavaClassName(javaClassName);
		return entity;
	}
	
}
