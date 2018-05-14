package com.techoffice.test.h2;

import org.junit.Test;

import com.techoffice.database.h2.dao.H2EntityDao;
import com.techoffice.generator.mybatis.EntityGenerator;
import com.techoffice.test.base.BaseGeneratorTest;

public class EntityGeneratorTest extends BaseGeneratorTest<EntityGenerator, H2EntityDao>{

	@Test
	public void test(){
		String content = generate("TEST");
		System.out.println(content);
	}
}
