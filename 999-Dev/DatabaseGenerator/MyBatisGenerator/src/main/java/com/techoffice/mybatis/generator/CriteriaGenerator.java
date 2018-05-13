package com.techoffice.mybatis.generator;

import com.techoffice.database.model.Entity;
import com.techoffice.freemarker.util.FreemakerUtil;

public class CriteriaGenerator {

	public static String generate(Entity entity){
		return FreemakerUtil.generate(CriteriaGenerator.class, entity);
	}
	
}
