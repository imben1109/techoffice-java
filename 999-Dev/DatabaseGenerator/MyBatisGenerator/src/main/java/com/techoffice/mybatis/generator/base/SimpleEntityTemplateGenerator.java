package com.techoffice.mybatis.generator.base;

import com.techoffice.database.model.Entity;
import com.techoffice.freemarker.util.FreemakerUtil;

public abstract class SimpleEntityTemplateGenerator {

	public String generate(Entity entity){
		return FreemakerUtil.generate(this.getClass(), entity);
	}
	
}
