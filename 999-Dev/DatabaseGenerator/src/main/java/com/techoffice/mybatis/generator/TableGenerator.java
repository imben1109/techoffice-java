package com.techoffice.mybatis.generator;

import com.techoffice.freemarker.util.FreemakerUtil;
import com.techoffice.mybatis.model.Entity;
import com.techoffice.mybatis.util.MockUtil;

public class TableGenerator {
	
	public static String generate(Entity entity){
		return FreemakerUtil.generate(TableGenerator.class, entity);
	}
	
	public static void main(String[] args){
		Entity entity = MockUtil.getMockEntity();
		String content = generate(entity);
		System.out.println(content);
	}
}
