package com.techoffice.oracle.convertor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.xml.internal.ws.util.StringUtils;
import com.techoffice.database.config.JdbcTypeMappingConfig;
import com.techoffice.database.config.annoation.JdbcTypeMapping;
import com.techoffice.oracle.dao.AllArgumentDao;
import com.techoffice.oracle.model.AllArgument;
import com.techoffice.util.StringUtil;

public class ArgumentConvertor {
	
	public static List<Map<String,String>> getDataMap(String packageName, String procedureName) {
		List<AllArgument> allArgumentList = AllArgumentDao.getInstance().getPackageProcedureArgumentList(packageName, procedureName);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (AllArgument allArgument: allArgumentList){
			String argumentName = StringUtil.upperUnderscoreToLowerCamel(allArgument.getArgumentName());
			if (argumentName.startsWith("pi")){
				argumentName = argumentName.substring(2);
				argumentName = StringUtils.decapitalize(argumentName);
			}
			JdbcTypeMapping sqlMapperMapping  = JdbcTypeMappingConfig.getJdbcTypeMapping(allArgument.getDataType());
			String jdbcType = sqlMapperMapping.jdbcType();
			String javaType = sqlMapperMapping.javaType();
			Map<String, String> map = new HashMap<String, String>();
			map.put("argumentName", argumentName);
			map.put("jdbcType", jdbcType);
			map.put("javaType", javaType);
			list.add(map);
		}
		return list;	
	}
	

}
