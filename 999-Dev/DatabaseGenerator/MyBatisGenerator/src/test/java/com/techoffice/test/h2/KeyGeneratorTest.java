package com.techoffice.test.h2;

import org.junit.Test;

import com.techoffice.mybatis.generator.KeyGenerator;
import com.techoffice.test.h2.base.BaseH2GeneratorTest;

public class KeyGeneratorTest extends BaseH2GeneratorTest<KeyGenerator> {

	@Test
	public void test(){
		String content = generate("TEST");
		System.out.println(content);
	}
	
}
