package com.techoffice.test.h2;

import org.junit.Test;

import com.techoffice.database.h2.dao.H2EntityDao;
import com.techoffice.generator.mybatis.KeyGenerator;
import com.techoffice.test.base.BaseGeneratorTest;

public class KeyGeneratorTest extends BaseGeneratorTest<KeyGenerator, H2EntityDao> {

	@Test
	public void test(){
		String content = generate("TEST");
		System.out.println(content);
	}
	
}
