package com.techoffice.generator.mybatis;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.techoffice.database.dao.model.Entity;
import com.techoffice.generator.mybatis.base.MulitpleEntityTemplateGenerator;
import com.techoffice.generator.mybatis.base.SimpleEntityTemplateGenerator;
import com.techoffice.generator.mybatis.config.MyBatisGeneratorConfig;

public class MyBatisGenerator extends MulitpleEntityTemplateGenerator{

	private CriteriaGenerator criteriaGenerator;
	private DaoGenerator daoGenerator;
	private EntityGenerator entityGenerator;
	private KeyGenerator keyGenerator;
	private ServiceGenerator serviceGenerator;
	private SqlMapperGenerator sqlMapperGenerator;
	private ControllerGenerator controllerGenerator;
	
	private List<SimpleEntityTemplateGenerator> templateGeneratorList;
	
	public MyBatisGenerator(){
		criteriaGenerator = new CriteriaGenerator();
		daoGenerator = new DaoGenerator();
		entityGenerator = new EntityGenerator();
		keyGenerator = new KeyGenerator();
		serviceGenerator = new ServiceGenerator();
		sqlMapperGenerator = new SqlMapperGenerator();
		controllerGenerator = new ControllerGenerator();
		
		templateGeneratorList = new ArrayList<SimpleEntityTemplateGenerator>();
		templateGeneratorList.add(criteriaGenerator);
		templateGeneratorList.add(daoGenerator);
		templateGeneratorList.add(entityGenerator);
		templateGeneratorList.add(keyGenerator);
		templateGeneratorList.add(serviceGenerator);
		templateGeneratorList.add(sqlMapperGenerator);
		templateGeneratorList.add(controllerGenerator);
	}
	
	public List<File> generate(Entity entity) {
		entity.getMetaMap().put("basePackage", MyBatisGeneratorConfig.getBasePackage());
		List<File> fileList = new ArrayList<File>();
		for (SimpleEntityTemplateGenerator simpleEntityTemplateGenerator: templateGeneratorList){
			File generateFile = MyBatisGeneratorConfig.getFile(simpleEntityTemplateGenerator, entity);
			String content = simpleEntityTemplateGenerator.generate(entity);
			try{
				FileUtils.forceMkdirParent(generateFile);
				FileUtils.writeStringToFile(generateFile, content, StandardCharsets.UTF_8);
				System.out.println(generateFile.getAbsolutePath() + " generated");
			}catch (Exception e){
				throw new RuntimeException(e);
			}
		}
		return fileList;
	}

}
