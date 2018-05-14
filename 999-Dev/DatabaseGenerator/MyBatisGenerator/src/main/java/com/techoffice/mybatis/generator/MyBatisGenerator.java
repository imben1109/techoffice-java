package com.techoffice.mybatis.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.techoffice.database.dao.EntityDao;
import com.techoffice.database.model.Entity;
import com.techoffice.database.registry.EntityDaoRegistry;
import com.techoffice.h2.dao.H2EntityDao;
import com.techoffice.mybatis.generator.base.MulitpleEntityTemplateGenerator;
import com.techoffice.mybatis.generator.base.SimpleEntityTemplateGenerator;

public class MyBatisGenerator extends MulitpleEntityTemplateGenerator{

	private CriteriaGenerator criteriaGenerator;
	private DaoGenerator daoGenerator;
	private EntityGenerator entityGenerator;
	private KeyGenerator keyGenerator;
	private ServiceGenerator serviceGenerator;
	private SqlMapperGenerator sqlMapperGenerator;
	private Map<String, SimpleEntityTemplateGenerator> generatorMap = new HashMap<String, SimpleEntityTemplateGenerator>();
	
	public MyBatisGenerator(){
		criteriaGenerator = new CriteriaGenerator();
		daoGenerator = new DaoGenerator();
		entityGenerator = new EntityGenerator();
		keyGenerator = new KeyGenerator();
		serviceGenerator = new ServiceGenerator();
		sqlMapperGenerator = new SqlMapperGenerator();
		
		addGenerator(criteriaGenerator);
		addGenerator(daoGenerator);
		addGenerator(entityGenerator);
		addGenerator(keyGenerator);
		addGenerator(serviceGenerator);
		addGenerator(sqlMapperGenerator);
	}
	
	public void addGenerator(SimpleEntityTemplateGenerator simpleEntityTemplateGenerator){
		generatorMap.put(simpleEntityTemplateGenerator.getClass().getSimpleName(), simpleEntityTemplateGenerator);
	}
	
	public List<File> generate(Entity entity) {
		List<File> fileList = new ArrayList<File>();
		for (String key: generatorMap.keySet()){
			SimpleEntityTemplateGenerator simpleEntityTemplateGenerator = generatorMap.get(key);
			String content = simpleEntityTemplateGenerator.generate(entity);
			System.out.println(key);
		}
		return fileList;
	}
	
	public static void main(String[] args){
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator();
		EntityDao entityDao = EntityDaoRegistry.getEntityDao(H2EntityDao.class);
		Entity entity = entityDao.getEntity("TEST");
		myBatisGenerator.generate(entity);
	}
}
