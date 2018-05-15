package com.techoffice.test.h2;

import org.junit.Test;

import com.techoffice.database.h2.dao.H2EntityDao;
import com.techoffice.generator.mybatis.ControllerGenerator;
import com.techoffice.test.base.BaseGeneratorTest;

public class ControllerGeneratorTest extends BaseGeneratorTest<ControllerGenerator, H2EntityDao> {

	@Test
	public void test(){
		String content = generate("TEST");
		System.out.println(content);
	}
	
}
