package com.techoffice.generator;

import java.lang.reflect.Field;

import com.techoffice.generator.mapping.DataTypeConfig;
import com.techoffice.generator.model.Test;
import com.techoffice.generator.util.StringUtil;

public class Appl {
	
	public static void main(String[] args){
		Field[] fields = Test.class.getDeclaredFields();
		for (int i=0; i<fields.length; i++){
			Field field = fields[i];
			String columnName = StringUtil.lowerCamelcaseToUpperUnderscore(field.getName());
			System.out.println(columnName);

		}
	}
	
}
