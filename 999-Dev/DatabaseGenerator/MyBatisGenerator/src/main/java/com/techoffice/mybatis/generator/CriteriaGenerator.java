package com.techoffice.mybatis.generator;

import com.techoffice.database.model.Entity;
import com.techoffice.freemarker.util.FreemakerUtil;
import com.techoffice.mybatis.generator.base.BaseTemplateGenerator;

public class CriteriaGenerator extends BaseTemplateGenerator {

	public static String generate(Entity entity){
		return FreemakerUtil.generate(CriteriaGenerator.class, entity);
	}
	
}
