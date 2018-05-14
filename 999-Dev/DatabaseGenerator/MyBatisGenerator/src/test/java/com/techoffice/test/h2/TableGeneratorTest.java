package com.techoffice.test.h2;

import org.junit.Test;

import com.techoffice.mybatis.generator.TableGenerator;
import com.techoffice.test.h2.base.BaseH2GeneratorTest;

public class TableGeneratorTest extends BaseH2GeneratorTest<TableGenerator> {

	@Test
	public void generate(){
		String content = generate("TEST");
		System.out.println(content);
	}
}
