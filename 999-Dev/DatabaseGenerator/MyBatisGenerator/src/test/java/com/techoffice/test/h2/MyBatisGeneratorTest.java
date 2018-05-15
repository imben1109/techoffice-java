package com.techoffice.test.h2;

import org.junit.Test;

import com.techoffice.database.dao.EntityDao;
import com.techoffice.database.dao.model.Entity;
import com.techoffice.database.dao.registry.EntityDaoRegistry;
import com.techoffice.database.h2.dao.H2EntityDao;
import com.techoffice.generator.mybatis.MyBatisGenerator;

public class MyBatisGeneratorTest {

	@Test
	public void test(){
		EntityDao entityDao = EntityDaoRegistry.getEntityDao(H2EntityDao.class);
		Entity entity = entityDao.getEntity("TEST");
		
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator();
		myBatisGenerator.generate(entity);
	}
}
