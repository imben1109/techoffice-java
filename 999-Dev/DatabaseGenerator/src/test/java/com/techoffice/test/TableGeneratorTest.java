package com.techoffice.test;

import java.util.List;

import org.junit.Test;

import com.techoffice.database.dao.EntityDao;
import com.techoffice.database.model.Entity;
import com.techoffice.database.model.Field;
import com.techoffice.database.registry.EntityDaoRegistry;
import com.techoffice.h2.dao.H2EntityDao;
import com.techoffice.mybatis.generator.TableGenerator;

public class TableGeneratorTest {

	@Test
	public void generate(){
		EntityDao entityDao = EntityDaoRegistry.getEntityDao(H2EntityDao.class);
		Entity entity = entityDao.getEntity("TEST");
		List<Field> fieldList = entity.getFieldList();
		String content = TableGenerator.generate(entity);
		System.out.println(content);
	}
}
