package com.techoffice.mybatis.generator;

import com.techoffice.database.model.Entity;
import com.techoffice.freemarker.util.FreemakerUtil;

public class EntityGenerator {

	public static String generate(Entity entity){
		return FreemakerUtil.generate(EntityGenerator.class, entity);
	}
	
}
