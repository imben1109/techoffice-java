package com.techoffice.test.h2;

import org.junit.Test;

import com.techoffice.mybatis.generator.EntityGenerator;
import com.techoffice.test.h2.base.BaseH2GeneratorTest;

public class EntityGeneratorTest extends BaseH2GeneratorTest<EntityGenerator>{

	@Test
	public void test(){
		String content = generate("TEST");
		System.out.println(content);
	}
}
