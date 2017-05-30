package com.techoffice.mybatis.oracle.sqlmap;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.techoffice.mybatis.oracle.dao.TableColumnDao;
import com.techoffice.mybatis.oracle.model.TableColumn;
import com.techoffice.mybatis.oracle.sqlmap.intf.SqlMapGenerator;
import com.techoffice.mybatis.oracle.util.SqlMapVariableHelper;

public class SelectSqlMapGenerator implements SqlMapGenerator{
	public static final String SQL_TEMPLATE = "SELECT \r\n{0} \r\nFROM {1} \r\nWHERE \r\n{2}\r\n;";

	public void generate(String tableName) {
		String columnStr = "";
		String whereStr = "";
		List<TableColumn> tableColumnList = TableColumnDao.getTableColumnList(tableName);
		List<String> columnNames = new ArrayList<String>();
		List<String> whereList = new ArrayList<String>();
		for(TableColumn tableColumn: tableColumnList){
			columnNames.add("\t" + tableColumn.getColumnName());
			whereList.add("\t" + tableColumn.getColumnName() + "\t = \t" + SqlMapVariableHelper.getVariable(tableColumn));
		}
		columnStr = StringUtils.join(columnNames, ",\r\n");
		whereStr = StringUtils.join(whereList, ",\r\n");
		String sql = MessageFormat.format(SQL_TEMPLATE, columnStr, tableName, whereStr);
		System.out.println(sql);
	}

	public static void main(String[] args){
		SelectSqlMapGenerator selectSqlMapGenerator = new SelectSqlMapGenerator();
		selectSqlMapGenerator.generate("help");
	}
}
