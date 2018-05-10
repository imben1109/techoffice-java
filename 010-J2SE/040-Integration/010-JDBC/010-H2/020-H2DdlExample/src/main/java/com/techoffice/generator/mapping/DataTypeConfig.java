package com.techoffice.generator.mapping;

import java.util.HashMap;
import java.util.Map;

import com.techoffice.generator.mapping.annotation.ClassType;
import com.techoffice.generator.mapping.annotation.DataTypeMapping;

@DataTypeMapping(classTypes = {
	@ClassType(classType = "java.lang.String", 		dataType = "VARCHAR2"),
	@ClassType(classType = "java.util.Date", 		dataType = "TIMESTAMP"),
	@ClassType(classType = "java.math.BigDecimal", 	dataType = "NUMBER"),
	@ClassType(classType = "java.lang.Integer", 	dataType = "NUMBER", 	precision=9)
})
public class DataTypeConfig {

	private DataTypeConfig(){}
	
	public static final Map<String, String> mapping = new HashMap<String, String>();
	
	static {

	}
	
	public static ClassType getDataType(String classTypeName){
		DataTypeMapping dataTypeMapping = DataTypeConfig.class.getAnnotation(DataTypeMapping.class);
		ClassType[] classTypes = dataTypeMapping.classTypes();
		for (int i=0; i<classTypes.length; i++){
			ClassType classType = classTypes[i];
			if(classType.classType().equals(classTypeName)){
				return classType;
			}
		}
		return null;
	}
	
	public static void main(String[] args){
		System.out.println(getDataType("java.lang.String").dataType());;
	}
}
