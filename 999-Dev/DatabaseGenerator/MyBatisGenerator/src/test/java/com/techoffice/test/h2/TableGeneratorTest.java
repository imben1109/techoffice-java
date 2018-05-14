package com.techoffice.test.h2;

import org.junit.Test;

import com.techoffice.database.model.Entity;
import com.techoffice.mybatis.generator.TableGenerator;
import com.techoffice.mybatis.util.MockUtil;
import com.techoffice.test.h2.base.BaseH2GeneratorTest;

public class TableGeneratorTest extends BaseH2GeneratorTest<TableGenerator> {

	@Test
	public void generate(){
		Entity entity = MockUtil.getMockEntity();
		String content = getTemplateGenerator().generate(entity);
		System.out.println(content);
	}
}
