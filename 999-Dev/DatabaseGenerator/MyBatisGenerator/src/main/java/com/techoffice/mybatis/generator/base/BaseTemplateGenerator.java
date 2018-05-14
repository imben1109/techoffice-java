package com.techoffice.mybatis.generator.base;

import com.techoffice.database.model.Entity;
import com.techoffice.freemarker.util.FreemakerUtil;

public abstract class BaseTemplateGenerator {

	public String generate(Entity entity){
		return FreemakerUtil.generate(this.getClass(), entity);
	}

	public static void main(String[] args){
		
	}
}
