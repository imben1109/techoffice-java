package com.techoffice.generator.mapping;

import java.util.HashMap;
import java.util.Map;

import com.techoffice.generator.mapping.annotation.DataTypeMapping;
import com.techoffice.generator.mapping.annotation.DataTypeMappings;

@DataTypeMappings({
	@DataTypeMapping(value = "java.lang.String", 		dataType = "VARCHAR2"),
	@DataTypeMapping(value = "java.util.Date", 			dataType = "TIMESTAMP"),
	@DataTypeMapping(value = "java.math.BigDecimal", 	dataType = "NUMBER"),
	@DataTypeMapping(value = "java.lang.Integer", 		dataType = "NUMBER", 	precision=9)
})
public class DataTypeUtil {

	private DataTypeUtil(){}
	
	public static final Map<String, String> mapping = new HashMap<String, String>();
	
	static {

	}
	
	public static DataTypeMapping getDataTypeMapping(String classTypeName){
		DataTypeMappings dataTypeMappings = DataTypeUtil.class.getAnnotation(DataTypeMappings.class);
		DataTypeMapping[] dataTypeMappingList = dataTypeMappings.value();
		for (int i=0; i<dataTypeMappingList.length; i++){
			DataTypeMapping dataTypeMapping = dataTypeMappingList[i];
			if(dataTypeMapping.value().equals(classTypeName)){
				return dataTypeMapping;
			}
		}
		return null;
	}
	
	public static DataTypeMapping getDataTypeMapping(Class<?> clazz){
		return getDataTypeMapping(clazz.getName());
	}
	
	public static String getDataType(String classTypeName){
		DataTypeMapping dataTypeMapping = getDataTypeMapping(classTypeName);
		return dataTypeMapping.dataType();
	}
	
	public static String getDataTypeSqlFragment(String classTypeName){
		DataTypeMapping dataTypeMapping = getDataTypeMapping(classTypeName);
		String columnDefinitionSqlFragment = dataTypeMapping.dataType();
		if (columnDefinitionSqlFragment.equals("NUMBER")
				&& dataTypeMapping.precision() > 0){
			columnDefinitionSqlFragment += "(" + dataTypeMapping.precision() + "," + dataTypeMapping.scale() + ")";
		}
		return columnDefinitionSqlFragment;
	}
	
	public static String getDataTypeSqlFragment(Class<?> clazz){
		return getDataTypeSqlFragment(clazz.getName());
	}
		
	public static void main(String[] args){
		System.out.println(getDataTypeMapping("java.lang.String").dataType());;
	}
}
