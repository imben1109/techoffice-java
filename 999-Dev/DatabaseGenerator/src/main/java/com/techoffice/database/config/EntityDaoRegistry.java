package com.techoffice.database.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.techoffice.database.dao.EntityDao;

public class EntityDaoRegistry {

	private static Map<Class<? extends EntityDao>, EntityDao> registry = new ConcurrentHashMap<Class<? extends EntityDao>, EntityDao>();

	public static void add(Class<? extends EntityDao> clazz, EntityDao entityDao){
		registry.put(clazz, entityDao);
	}
	
	public static EntityDao getEntityDao(Class<? extends EntityDao> clazz){
		return registry.get(clazz);
	}
	
	public static Map<Class<? extends EntityDao>, EntityDao> getRegistry(){
		return registry;
	}
	
	public static boolean isExist(Class<? extends EntityDao> clazz){
		return registry.containsKey(clazz);
	}
	
	private EntityDaoRegistry(){};
	
}
