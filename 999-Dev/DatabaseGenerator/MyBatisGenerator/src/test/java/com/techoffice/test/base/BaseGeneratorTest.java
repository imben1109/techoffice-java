package com.techoffice.test.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.techoffice.database.dao.EntityDao;
import com.techoffice.database.dao.model.Entity;
import com.techoffice.database.dao.registry.EntityDaoRegistry;
import com.techoffice.database.h2.dao.H2EntityDao;
import com.techoffice.generator.mybatis.base.SimpleEntityTemplateGenerator;

public abstract class BaseGeneratorTest<T extends SimpleEntityTemplateGenerator, K extends EntityDao> {

	public List<Class<?>> getParameterClasslist(){
		List<Class<?>> classList = new ArrayList<Class<?>>();
		Type type = this.getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType){
			ParameterizedType parameterizedType = (ParameterizedType) type;
			Type[] typeArguements = parameterizedType.getActualTypeArguments();
			for (int i=0; i<typeArguements.length; i++){
				Type typeArguement = typeArguements[i];
				if (typeArguement instanceof Class<?>){
					Class<?> clazz = (Class<?>) typeArguement;
					classList.add(clazz);
				}else {
					throw new RuntimeException("Failed to get Parameterized Class List");
				}
			}
		}else {
			throw new RuntimeException("Failed to get Parameterized Class List");
		}
		return classList;
	}
	
	public EntityDao getEntityDao(){
		Class<?> clazz = getParameterClasslist().get(1);
		@SuppressWarnings("unchecked")
		Class<K> kClass =  (Class<K>) clazz;
		EntityDao entityDao = EntityDaoRegistry.getEntityDao(kClass);
		return entityDao;
	}
	
	public Entity getEntity(String tableName){
		EntityDao entityDao = getEntityDao();
		Entity entity = entityDao.getEntity(tableName);
		return entity;
	}
	
	public SimpleEntityTemplateGenerator getTemplateGenerator(){
		Class<?> clazz = getParameterClasslist().get(0);
		Object object;
		try {
			object = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		if (object instanceof SimpleEntityTemplateGenerator){
			return (SimpleEntityTemplateGenerator) object;
		}else {
			throw new RuntimeException("Fail to get Template Generator");		
		}
	}
	
	public String generate(String tableName){
		Entity entity = getEntity(tableName);
		SimpleEntityTemplateGenerator tempalteGenerator = getTemplateGenerator();
		return tempalteGenerator.generate(entity);
	}
}
