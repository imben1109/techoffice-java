package com.techoffice.test.h2;

import org.junit.Test;

import com.techoffice.mybatis.generator.CriteriaGenerator;
import com.techoffice.test.h2.base.BaseH2GeneratorTest;

public class CriteriaGeneratorTest extends BaseH2GeneratorTest<CriteriaGenerator> {

	@Test
	public void test(){
		String content = generate("TEST");
		System.out.println(content);
	}
}
