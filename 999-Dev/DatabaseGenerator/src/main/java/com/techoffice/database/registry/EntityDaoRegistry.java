package com.techoffice.database.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.techoffice.database.dao.EntityDao;

public class EntityDaoRegistry {

	private static Map<Class<? extends EntityDao>, EntityDao> registry = new ConcurrentHashMap<Class<? extends EntityDao>, EntityDao>();

	public static void add(Class<? extends EntityDao> clazz, EntityDao entityDao){
		registry.put(clazz, entityDao);
	}
	
	public static EntityDao getEntityDao(Class<? extends EntityDao> clazz){
		EntityDao entityDao = registry.get(clazz);
		if (entityDao != null){
			return entityDao;
		}
		try {
			Class.forName(clazz.getName());
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entityDao;
	}
	
	public static Map<Class<? extends EntityDao>, EntityDao> getRegistry(){
		return registry;
	}
	
	public static boolean isExist(Class<? extends EntityDao> clazz){
		return registry.containsKey(clazz);
	}
	
	private EntityDaoRegistry(){};
	
}
