package com.techoffice.test.h2.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.techoffice.database.dao.EntityDao;
import com.techoffice.database.model.Entity;
import com.techoffice.database.registry.EntityDaoRegistry;
import com.techoffice.h2.dao.H2EntityDao;
import com.techoffice.mybatis.generator.base.BaseTemplateGenerator;

public abstract class BaseH2GeneratorTest<T extends BaseTemplateGenerator> {

	public EntityDao getEntityDao(){
		EntityDao entityDao = EntityDaoRegistry.getEntityDao(H2EntityDao.class);
		return entityDao;
	}
	
	public Entity getEntity(String tableName){
		EntityDao entityDao = getEntityDao();
		Entity entity = entityDao.getEntity(tableName);
		return entity;
	}
	
	public BaseTemplateGenerator getTemplateGenerator(){
		Type type = this.getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType){
			ParameterizedType parameterizedType = (ParameterizedType) type;
			if (parameterizedType.getActualTypeArguments().length > 0 ){
				Type typeArguement = parameterizedType.getActualTypeArguments()[0];
				if (typeArguement instanceof Class<?>){
					Class<?> clazz = (Class<?>) typeArguement;
					System.out.println(clazz);
					try {
						Object object = clazz.newInstance();
						if (object instanceof BaseTemplateGenerator){
							return (BaseTemplateGenerator) object;
						}else {
							throw new RuntimeException("Fail to get Template Generator");		
						}
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}else {
					throw new RuntimeException("Fail to get Template Generator");	
				}
			}else{
				throw new RuntimeException("Fail to get Template Generator");	
			}
		}else {
			throw new RuntimeException("Fail to get Template Generator");
		}
	}
	
	public String generate(String tableName){
		Entity entity = getEntity(tableName);
		BaseTemplateGenerator tempalteGenerator = getTemplateGenerator();
		return tempalteGenerator.generate(entity);
	}
}
