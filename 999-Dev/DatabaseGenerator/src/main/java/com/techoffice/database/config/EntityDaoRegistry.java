package com.techoffice.database.config;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.techoffice.database.dao.EntityDao;

public class EntityDaoRegistry {

	private static Set<EntityDao> registry = Collections.synchronizedSet(new HashSet<EntityDao>());

	public static void add(EntityDao entityDao){
		registry.add(entityDao);
	}
	
	public static Set<EntityDao> getRegistry(){
		return registry;
	}
	
	public static boolean isExist(EntityDao entityDao){
		return registry.contains(entityDao);
	}
}
