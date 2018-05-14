package com.techoffice.test.h2;

import org.junit.Test;

import com.techoffice.database.dao.EntityDao;
import com.techoffice.database.model.Entity;
import com.techoffice.database.registry.EntityDaoRegistry;
import com.techoffice.h2.dao.H2EntityDao;
import com.techoffice.mybatis.generator.CriteriaGenerator;

public class SearchCriteriaGeneratorTest {

	@Test
	public void test(){
		EntityDao entityDao = EntityDaoRegistry.getEntityDao(H2EntityDao.class);
		Entity entity = entityDao.getEntity("TEST");
		String content = CriteriaGenerator.generate(entity);
		System.out.println(content);
	}
}
