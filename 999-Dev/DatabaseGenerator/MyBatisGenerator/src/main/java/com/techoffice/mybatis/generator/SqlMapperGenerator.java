package com.techoffice.mybatis.generator;

import com.techoffice.database.dao.EntityDao;
import com.techoffice.database.model.Entity;
import com.techoffice.database.registry.EntityDaoRegistry;
import com.techoffice.freemarker.util.FreemakerUtil;
import com.techoffice.h2.dao.H2EntityDao;
import com.techoffice.mybatis.generator.base.BaseTemplateGenerator;

public class SqlMapperGenerator extends BaseTemplateGenerator  {

	public static String generate(Entity entity){
		return FreemakerUtil.generate(SqlMapperGenerator.class, entity);
	}
	
	public static void main(String[] args){
		EntityDao entityDao = EntityDaoRegistry.getEntityDao(H2EntityDao.class);
		Entity entity = entityDao.getEntity("TEST");
		String content = SqlMapperGenerator.generate(entity);
		System.out.println(content);
	}
}
