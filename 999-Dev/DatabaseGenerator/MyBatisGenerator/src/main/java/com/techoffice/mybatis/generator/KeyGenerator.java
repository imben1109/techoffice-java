package com.techoffice.mybatis.generator;

import org.junit.Test;

import com.techoffice.database.dao.EntityDao;
import com.techoffice.database.model.Entity;
import com.techoffice.database.registry.EntityDaoRegistry;
import com.techoffice.freemarker.util.FreemakerUtil;
import com.techoffice.h2.dao.H2EntityDao;

public class KeyGenerator {

	public static String generate(Entity entity){
		return FreemakerUtil.generate(KeyGenerator.class, entity);
	}

	@Test
	public void entityGenertorTest(){
		EntityDao entityDao = EntityDaoRegistry.getEntityDao(H2EntityDao.class);
		Entity entity = entityDao.getEntity("TEST");
		String content = KeyGenerator.generate(entity);
		System.out.println(content);
	}
}
