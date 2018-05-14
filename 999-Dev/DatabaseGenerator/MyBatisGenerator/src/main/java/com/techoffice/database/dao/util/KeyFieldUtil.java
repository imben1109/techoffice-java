package com.techoffice.database.dao.util;

import java.util.List;

import com.techoffice.database.dao.model.Field;

public class KeyFieldUtil {

	private KeyFieldUtil(){} 
	
	public static void markKeyField(List<Field> fieldList, List<Field> keyFieldList){
		for (Field field: fieldList){
			if (keyFieldList.contains(field)){
				field.setKey(true);
			}
		}
	}
	
	public static void markKeyField(List<Field> keyFieldList){
		for (Field field: keyFieldList){
			field.setKey(true);
		}
	}
}
