package com.techoffice.generator.mybatis.base;

import com.techoffice.database.dao.model.Entity;
import com.techoffice.generator.freemarker.util.FreemakerUtil;

public abstract class SimpleEntityTemplateGenerator {

	public String generate(Entity entity){
		return FreemakerUtil.generate(this.getClass(), entity);
	}
	
}
