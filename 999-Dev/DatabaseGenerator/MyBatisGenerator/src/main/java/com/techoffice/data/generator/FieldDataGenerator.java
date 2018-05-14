package com.techoffice.data.generator;

import com.techoffice.data.generator.model.FieldData;
import com.techoffice.data.generator.type.base.BaseTypeGenerator;
import com.techoffice.data.generator.type.registry.TypeGeneratorRegistry;
import com.techoffice.database.model.Field;

public class FieldDataGenerator {

	public static FieldDataGenerator instance = new FieldDataGenerator();
	
	public static FieldDataGenerator getInstance(){
		return instance;
	}
	
	private FieldDataGenerator(){}
	
	public FieldData generate(Field field){
		FieldData fieldData = new FieldData();		
		Class<?> javaClass = null;
		try{
			javaClass = Class.forName(field.getJavaFullType());
		}catch(ClassNotFoundException e){
			throw new RuntimeException(e);
		}
		BaseTypeGenerator<?> typeGenerator = TypeGeneratorRegistry.getTypeGenerator(javaClass);
		if (typeGenerator == null){
			throw new RuntimeException("Failed to get Type Generator from Registy: " + javaClass.getName());
		}
		Object value = typeGenerator.generate(field);
		fieldData.setValue(value);
		fieldData.setField(field);
		return fieldData;

	}
	
}
