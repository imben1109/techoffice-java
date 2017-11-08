package com.techoffice.oracle.sqlmap.generator;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techoffice.oracle.config.OracleConfig;
import com.techoffice.oracle.constant.PackageConstant;
import com.techoffice.oracle.dao.TableDao;
import com.techoffice.oracle.model.Column;
import com.techoffice.oracle.util.PackageUtil;
import com.techoffice.oracle.util.PojoUtil;

@Component
public class SqlMapGenerator {
	
	public String generateSqlMap(String tableName, List<Column> columns){
		String packageName = OracleConfig.getGeneratorPackage();
		StringWriter procContent = new StringWriter();
		PrintWriter printWriter = new PrintWriter(procContent);	
		printWriter.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		printWriter.println("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"");
		printWriter.println("                        \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">");
		printWriter.println(String.format("<mapper namespace=\"%s\">", packageName + "." + PojoUtil.getClassName(tableName) + "Dao"));
		printWriter.println();

		String resultMap = genResultMap(tableName, columns);
//		System.out.println(resultMap);
		String search = genCallSearch(tableName, columns);
//		System.out.println(search);
		String insert = genCallInsert(tableName, columns);
//		System.out.println(insert);
		String update = this.genCallUpdate(tableName, columns);
//		System.out.println(update);
		String delete = this.genCallDelete(tableName, columns);
//		System.out.println(delete);
		printWriter.println(resultMap);
		printWriter.println(search);
		printWriter.println(insert);
		printWriter.println(update);
		printWriter.println(delete);
		printWriter.println("</mapper>");
		printWriter.println();
		printWriter.flush();
		printWriter.close();
		return procContent.toString();
	}
	
	public String genCallInsert(String tableName, List<Column> columns){
		StringWriter procContent = new StringWriter();
		PrintWriter printWriter = new PrintWriter(procContent);	
		printWriter.println(String.format("  <select id=\"%s\" statementType=\"CALLABLE\" parameterType=\"java.util.Map\">", "insert"));
		printWriter.println(String.format("    { call %s.%s(", PackageUtil.getPackageName(tableName), PackageUtil.getInsertProc(tableName)));
		List<String> paramList = new ArrayList<String>();
		for (Column column: columns){
			String javaField = PojoUtil.getFieldName(column.getColumnName());
			String jdbcType = column.getDataType();
			String javaType = PojoUtil.getJavaType(column);
			paramList.add(String.format("        #{%s, jdbcType=%s, javaType=%s, mode=IN}", javaField, jdbcType, javaType));
		}
		printWriter.println(StringUtils.join(paramList, ",\r\n"));
		printWriter.println(String.format("    )}"));
		printWriter.println(String.format("  </select>"));
		printWriter.println(String.format(""));
		printWriter.println(String.format(""));
		printWriter.flush();
		printWriter.close();
		return procContent.toString();
	}
	
	public String genResultMap(String tableName, List<Column> columns){
		StringWriter procContent = new StringWriter();
		PrintWriter printWriter = new PrintWriter(procContent);	
		String javaPackage = OracleConfig.getGeneratorPackage();
		String javaClassName = PojoUtil.getClassName(tableName);
		String resultMapId = getResultMapId(tableName);
		String type = javaPackage + "." + javaClassName;
		printWriter.println(String.format("  <resultMap id=\"%s\" type=\"%s\">", resultMapId, type));
		for (Column column: columns){
			String property = PojoUtil.getFieldName(column.getColumnName());
			printWriter.println(String.format("    <result property=\"%s\" column=\"%s\"/>", property, column.getColumnName()));
		}
		printWriter.println(String.format("  </resultMap>"));
		printWriter.flush();
		printWriter.close();
		return procContent.toString();
	}
	
	public String genCallSearch(String tableName, List<Column> columns){
		StringWriter procContent = new StringWriter();
		PrintWriter printWriter = new PrintWriter(procContent);	
		printWriter.println(String.format("  <select id=\"%s\" statementType=\"CALLABLE\" parameterType=\"java.util.Map\">", "search"));
		printWriter.println(String.format("    { call %s.%s(", PackageUtil.getPackageName(tableName), PackageUtil.getSearchProc(tableName)));
		List<String> paramList = new ArrayList<String>();
		for (Column column: columns){
			String javaField = PojoUtil.getFieldName(column.getColumnName());
			String jdbcType = column.getDataType();
			String javaType = PojoUtil.getJavaType(column);
			paramList.add(String.format("        #{%s, jdbcType=%s, javaType=%s, mode=IN}", javaField, jdbcType, javaType));
		}
		paramList.add(String.format("        #{%s, jdbcType=%s, javaType=%s, mode=IN}", "currentPage", "NUMBER", "int"));
		paramList.add(String.format("        #{%s, jdbcType=%s, javaType=%s, mode=IN}", "pageSize", "NUMBER", "int"));
		paramList.add(String.format("        #{%s, jdbcType=%s, javaType=%s, mode=OUT, resultMap=%s}", "result", "CURSOR", "java.sql.ResultSet", getResultMapId(tableName)));
		printWriter.println(StringUtils.join(paramList, ",\r\n"));
		printWriter.println(String.format("    )}"));
		printWriter.println(String.format("  </select>"));
		printWriter.println(String.format(""));
		printWriter.println(String.format(""));
		printWriter.flush();
		printWriter.close();
		return procContent.toString();
	}
	
	public String genCallUpdate(String tableName, List<Column> columns){
		StringWriter procContent = new StringWriter();
		PrintWriter printWriter = new PrintWriter(procContent);	
		printWriter.println(String.format("  <select id=\"%s\" statementType=\"CALLABLE\" parameterType=\"java.util.Map\">", "update"));
		printWriter.println(String.format("    { call %s.%s(", PackageUtil.getPackageName(tableName), PackageUtil.getUpdateProc(tableName)));
		List<String> paramList = new ArrayList<String>();
		for (Column column: columns){
			String javaField = PojoUtil.getFieldName(column.getColumnName());
			String jdbcType = column.getDataType();
			String javaType = PojoUtil.getJavaType(column);
			paramList.add(String.format("        #{%s, jdbcType=%s, javaType=%s, mode=IN}", javaField, jdbcType, javaType));
		}
		printWriter.println(StringUtils.join(paramList, ",\r\n"));
		printWriter.println(String.format("    )}"));
		printWriter.println(String.format("  </select>"));
		printWriter.println(String.format(""));
		printWriter.println(String.format(""));
		printWriter.flush();
		printWriter.close();
		return procContent.toString();
	}

	public String genCallDelete(String tableName, List<Column> columns){
		StringWriter procContent = new StringWriter();
		PrintWriter printWriter = new PrintWriter(procContent);	
		printWriter.println(String.format("  <select id=\"%s\" statementType=\"CALLABLE\" parameterType=\"java.util.Map\">", "delete"));
		printWriter.println(String.format("    { call %s.%s(", PackageUtil.getPackageName(tableName), PackageUtil.getInsertProc(tableName)));
		List<String> paramList = new ArrayList<String>();
		for (Column column: columns){
			if (column.getPk() == 1){
				String javaField = PojoUtil.getFieldName(column.getColumnName());
				String jdbcType = column.getDataType();
				String javaType = PojoUtil.getJavaType(column);
				paramList.add(String.format("        #{%s, jdbcType=%s, javaType=%s, mode=IN}", javaField, jdbcType, javaType));
			}
		}
		printWriter.println(StringUtils.join(paramList, ",\r\n"));
		printWriter.println(String.format("    )}"));
		printWriter.println(String.format("  </select>"));
		printWriter.println(String.format(""));
		printWriter.println(String.format(""));
		printWriter.flush();
		printWriter.close();
		return procContent.toString();
	}
	
	private String getResultMapId(String tableName){
		String resultMapId = convertFirstCharToLowerCase(PojoUtil.getClassName(tableName)) + "ResultMap";
		return resultMapId;
	}
	
	private String convertFirstCharToLowerCase(String str){
		String firstChar = str.substring(0, 1);
		String convertedStr = firstChar.toLowerCase() + str.substring(1);
		return convertedStr;
	}
}
