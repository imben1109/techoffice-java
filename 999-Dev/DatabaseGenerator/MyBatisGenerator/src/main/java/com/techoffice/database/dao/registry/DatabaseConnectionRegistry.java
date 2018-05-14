package com.techoffice.database.dao.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.techoffice.database.dao.connection.DatabaseConnection;

public class DatabaseConnectionRegistry {
	
	private static Map<Class<?>, DatabaseConnection> registry = new ConcurrentHashMap<Class<?>, DatabaseConnection>();
	
	public static void add(Class<? extends DatabaseConnection> clazz, DatabaseConnection databaseConnection){
		registry.put(clazz, databaseConnection);
	}
	
	public static DatabaseConnection getDatabaseConnection(Class<? extends DatabaseConnection> clazz){
		DatabaseConnection databaseConnection = registry.get(clazz);
		if (databaseConnection != null){
			return databaseConnection;
		}
		try {
			Class.forName(clazz.getName());
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return databaseConnection;
	}
	
	public static Map<Class<?>, DatabaseConnection> getRegistry(){
		return registry;
	}
	
	public static boolean isExist(Class<? extends DatabaseConnection> clazz){
		return registry.containsKey(clazz);
	}
	
	private DatabaseConnectionRegistry(){};
}
