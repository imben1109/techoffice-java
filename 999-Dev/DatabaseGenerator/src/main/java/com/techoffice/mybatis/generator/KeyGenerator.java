package com.techoffice.mybatis.generator;

import com.techoffice.database.model.Entity;
import com.techoffice.freemarker.util.FreemakerUtil;

public class KeyGenerator {

	public static String generate(Entity entity){
		return FreemakerUtil.generate(KeyGenerator.class, entity);
	}
	
}
