package com.techoffice.mybatis.generator;

import com.techoffice.database.model.Entity;
import com.techoffice.freemarker.util.FreemakerUtil;

public class SqlMapperGenerator {

	public static String generate(Entity entity){
		return FreemakerUtil.generate(SqlMapperGenerator.class, entity);
	}
	
}
