package com.techoffice.mybatis.generator;

import com.techoffice.database.model.Entity;
import com.techoffice.freemarker.util.FreemakerUtil;

public class ServiceGenerator {

	public static String generate(Entity entity){
		return FreemakerUtil.generate(ServiceGenerator.class, entity);
	}
	
}
