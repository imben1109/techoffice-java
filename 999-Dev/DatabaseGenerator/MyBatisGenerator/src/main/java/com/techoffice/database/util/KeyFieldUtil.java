package com.techoffice.database.util;

import java.util.List;

import com.techoffice.database.model.Field;

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
