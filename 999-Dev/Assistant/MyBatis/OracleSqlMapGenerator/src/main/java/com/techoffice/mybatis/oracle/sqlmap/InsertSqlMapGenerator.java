package com.techoffice.mybatis.oracle.sqlmap;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.CaseFormat;
import com.techoffice.mybatis.oracle.dao.TableColumnDao;
import com.techoffice.mybatis.oracle.model.TableColumn;
import com.techoffice.mybatis.oracle.sqlmap.intf.SqlMapGenerator;
import com.techoffice.mybatis.oracle.util.JdbcTypeMapper;
import com.techoffice.mybatis.oracle.util.SqlMapVariableHelper;

public class InsertSqlMapGenerator implements SqlMapGenerator{

	public static final String SQL_TEMPLATE = "INSERT INTO {0} (\r\n{1}\r\n) VALUES (\r\n{2}\r\n);";
	
	public void generate(String tableName) {
		String columnStr = "";
		String valueStr = "";
		tableName = tableName.toUpperCase();
		List<TableColumn> tableColumnList = TableColumnDao.getTableColumnList(tableName);
		List<String> columnNames = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		for(TableColumn tableColumn: tableColumnList){
			columnNames.add("\t" + tableColumn.getColumnName());
			String value = "\t" + SqlMapVariableHelper.getVariable(tableColumn);
			valueList.add(value);
		}
		columnStr = StringUtils.join(columnNames, ",\r\n");
		valueStr = StringUtils.join(valueList, ",\r\n");
		String sql = MessageFormat.format(SQL_TEMPLATE, tableName, columnStr, valueStr);
		System.out.println(sql);
	}
	
	public static void main(String[] args){
		InsertSqlMapGenerator insertSqlMapGenerator = new InsertSqlMapGenerator();
		insertSqlMapGenerator.generate("help");
	}

}
