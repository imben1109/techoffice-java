package com.techoffice.mybatis.generator;

import com.techoffice.database.model.Entity;
import com.techoffice.freemarker.util.FreemakerUtil;

public class DaoGenerator {

	public static String generate(Entity entity){
		return FreemakerUtil.generate(DaoGenerator.class, entity);
	}
	
}
