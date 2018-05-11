package com.techoffice.mybatis.config;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DatabaseRegistry {

	private static Set<String> registry = Collections.synchronizedSet(new HashSet<String>());

	public static void add(String str){
		registry.add(str);
	}
	
	public static Set<String> getRegistry(){
		return registry;
	}
	
	public static boolean isExist(String str){
		return registry.contains(str);
	}
}
