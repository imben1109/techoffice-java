package com.techoffice.test.h2;

import org.junit.Test;

import com.techoffice.mybatis.generator.DaoGenerator;
import com.techoffice.test.h2.base.BaseH2GeneratorTest;

public class DaoGeneratorTest extends BaseH2GeneratorTest<DaoGenerator>{

	@Test
	public void test(){
		String content = generate("TEST");
		System.out.println(content);
	}
	
}
