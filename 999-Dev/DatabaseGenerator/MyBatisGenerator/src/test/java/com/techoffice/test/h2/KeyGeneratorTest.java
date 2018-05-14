package com.techoffice.test.h2;

import org.junit.Test;

import com.techoffice.database.dao.EntityDao;
import com.techoffice.database.model.Entity;
import com.techoffice.mybatis.generator.KeyGenerator;
import com.techoffice.test.h2.base.BaseH2GeneratorTest;

public class KeyGeneratorTest extends BaseH2GeneratorTest {

	@Test
	public void test(){
		EntityDao entityDao = getEntityDao();
		Entity entity = entityDao.getEntity("TEST");
		String content = KeyGenerator.generate(entity);
		System.out.println(content);
	}
	
}
