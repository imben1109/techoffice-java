package com.techoffice.test.h2;

import org.junit.Test;

import com.techoffice.h2.dao.H2EntityDao;
import com.techoffice.mybatis.generator.CriteriaGenerator;
import com.techoffice.test.base.BaseGeneratorTest;

public class CriteriaGeneratorTest extends BaseGeneratorTest<CriteriaGenerator, H2EntityDao> {

	@Test
	public void test(){
		String content = generate("TEST");
		System.out.println(content);
	}
}
