package com.techoffice.test.h2;

import org.junit.Test;

import com.techoffice.database.dao.model.Entity;
import com.techoffice.database.h2.dao.H2EntityDao;
import com.techoffice.generator.mybatis.TableGenerator;
import com.techoffice.generator.mybatis.util.MockUtil;
import com.techoffice.test.base.BaseGeneratorTest;

public class TableGeneratorTest extends BaseGeneratorTest<TableGenerator, H2EntityDao> {

	@Test
	public void generate(){
		Entity entity = MockUtil.getMockEntity();
		String content = getTemplateGenerator().generate(entity);
		System.out.println(content);
	}
}
