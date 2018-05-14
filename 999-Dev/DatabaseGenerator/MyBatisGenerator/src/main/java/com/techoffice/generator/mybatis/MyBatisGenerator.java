package com.techoffice.generator.mybatis;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.techoffice.database.dao.model.Entity;
import com.techoffice.generator.mybatis.base.MulitpleEntityTemplateGenerator;
import com.techoffice.generator.mybatis.base.SimpleEntityTemplateGenerator;

public class MyBatisGenerator extends MulitpleEntityTemplateGenerator{

	private CriteriaGenerator criteriaGenerator;
	private DaoGenerator daoGenerator;
	private EntityGenerator entityGenerator;
	private KeyGenerator keyGenerator;
	private ServiceGenerator serviceGenerator;
	private SqlMapperGenerator sqlMapperGenerator;
	private List<SimpleEntityTemplateGenerator> templateGeneratorList;
	
	public MyBatisGenerator(){
		criteriaGenerator = new CriteriaGenerator();
		daoGenerator = new DaoGenerator();
		entityGenerator = new EntityGenerator();
		keyGenerator = new KeyGenerator();
		serviceGenerator = new ServiceGenerator();
		sqlMapperGenerator = new SqlMapperGenerator();
		
		templateGeneratorList = new ArrayList<SimpleEntityTemplateGenerator>();
		templateGeneratorList.add(criteriaGenerator);
		templateGeneratorList.add(daoGenerator);
		templateGeneratorList.add(entityGenerator);
		templateGeneratorList.add(keyGenerator);
		templateGeneratorList.add(serviceGenerator);
		templateGeneratorList.add(sqlMapperGenerator);
	}
	
	public List<File> generate(Entity entity) {
		List<File> fileList = new ArrayList<File>();
		for (SimpleEntityTemplateGenerator simpleEntityTemplateGenerator: templateGeneratorList){
			simpleEntityTemplateGenerator.generate(entity);
		}
		return fileList;
	}

}
