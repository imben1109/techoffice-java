package com.techoffice.test.h2;

import org.junit.Test;

import com.techoffice.h2.dao.H2EntityDao;
import com.techoffice.mybatis.generator.DaoGenerator;
import com.techoffice.test.base.BaseGeneratorTest;

public class DaoGeneratorTest extends BaseGeneratorTest<DaoGenerator, H2EntityDao>{

	@Test
	public void test(){
		String content = generate("TEST");
		System.out.println(content);
	}
	
}
