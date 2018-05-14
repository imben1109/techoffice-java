package com.techoffice.data.generator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.techoffice.database.model.Entity;

public class EntityDataGenerator {

	public static final List<Class<?>> SUPPORT_TYPE_LIST = Arrays.asList(String.class, Integer.class);
	private EntityDataGenerator(){}
	
	public static void getDeclaredFileds(Object object){
		Field[] fields = object.getClass().getDeclaredFields();
		for(int i=0; i<fields.length; i++){
			Field field = fields[i];
			System.out.println(field.getName());
			System.out.println(field.getType());
		}
	}
	
	public static void main(String[] args){
		Entity entity= new Entity();
		getDeclaredFileds(entity);
		for (Class<?> clazz: SUPPORT_TYPE_LIST){
			System.out.println(clazz.getName());
		}
	}
}
