package com.techoffice.oracle.ppackage.generator;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techoffice.oracle.constant.PackageConstant;
import com.techoffice.oracle.dao.TableDao;
import com.techoffice.oracle.model.Column;

@Component
public class PackageBodyGenerator {

	@Autowired
	private TableDao tableDao;
	
	public String generatePackageBody(String tableName){
		List<Column> columns = tableDao.getTableColumnList(tableName);
		StringWriter procContent = new StringWriter();
		PrintWriter printWriter = new PrintWriter(procContent);
		printWriter.println(String.format("CREATE OR REPLACE PACKAGE BODY %s_%s AS ", PackageConstant.PACKAGE_PREFIX, tableName));
		printWriter.println(String.format(""));
		String insertProc = genInsertProc(tableName, columns);
		printWriter.println(String.format("%s", insertProc));
//		System.out.println(insertProc);
		String searchProc = genSearchProc(tableName, columns);
		printWriter.println(String.format("%s", searchProc));
//		System.out.println(serchProc);
		String updateProc = genUpdateProc(tableName, columns);
		printWriter.println(String.format("%s", updateProc));
//		System.out.println(updateProc);
		String deleteProc = genDeleteProc(tableName, columns);
		printWriter.println(String.format("%s", deleteProc));
		printWriter.println(String.format("END %s_%s;", PackageConstant.PACKAGE_PREFIX, tableName));
		printWriter.println(String.format(""));
		printWriter.flush();
		printWriter.close();
		return procContent.toString();
	}
	
	public String genInsertProc(String tableName, List<Column> columns ){
		StringWriter procContent = new StringWriter();
		PrintWriter printWriter = new PrintWriter(procContent);
		printWriter.println(String.format("  PROCEDURE %s_%s (", PackageConstant.INSERT_PREFIX, tableName));
		List<String> paramList = new ArrayList<String>();
		for (Column column: columns){
			paramList.add(String.format("    P_IN_%-10s %-10s", column.getColumnName(), column.getDataType()));
		}
		printWriter.println(StringUtils.join(paramList, ",\r\n"));
		printWriter.println(String.format("  ) AS "));
		printWriter.println(String.format("  BEGIN"));
		printWriter.println(String.format("    INSERT INTO %s (", tableName));
		List<String> columnNameList = new ArrayList<String>();
		for (Column column: columns){
			columnNameList.add("      " + column.getColumnName());
		}
		printWriter.println(StringUtils.join(columnNameList, ",\r\n"));
		printWriter.println(String.format("    ) VALUES ("));
		List<String> valueList = new ArrayList<String>();
		for (Column column: columns){
			valueList.add(String.format("      %-10s", "P_IN_" + column.getColumnName()));
		}
		printWriter.println(StringUtils.join(valueList, ",\r\n"));
		printWriter.println(String.format("    );"));
		printWriter.println(String.format("  END;"));
		
		printWriter.println(String.format(""));

		printWriter.flush();
		printWriter.close();
		return procContent.toString();
	}
	
	public String genSearchProc(String tableName, List<Column> columns){
		StringWriter procContent = new StringWriter();
		PrintWriter printWriter = new PrintWriter(procContent);
		printWriter.println(String.format("  PROCEDURE %s_%s ( ", PackageConstant.SEARCH_PREFIX, tableName));
		List<String> paramList = new ArrayList<String>();
		for (Column column: columns){
			paramList.add(String.format("    P_IN_%-15s  IN  %-10s", column.getColumnName(), column.getDataType()));
		}
		paramList.add(String.format("    P_IN_%-15s  IN  %-10s", "CURRENT_PAGE", "NUMBER"));
		paramList.add(String.format("    P_IN_%-15s  IN  %-10s", "PAGE_SIZE", "NUMBER"));
		paramList.add(String.format("    P_OUT_%-15s OUT %-10s", "RESULT_CUR", "SYS_REFCURSOR"));

		printWriter.println(StringUtils.join(paramList, ",\r\n"));
		printWriter.println(String.format("  ) AS"));
		printWriter.println(String.format("  BEGIN"));
		printWriter.println(String.format("    OPEN P_OUT_RESULT_CUR FOR "));
		printWriter.println(String.format("      SELECT * FROM ("));
		printWriter.println(String.format("        SELECT"));
		List<String> columnNameList = new ArrayList<String>();
		for (Column column: columns){
			columnNameList.add("          " + column.getColumnName());
		}
		columnNameList.add("          rownum row_num" );
		columnNameList.add("          count(1) over () total" );
		printWriter.println(StringUtils.join(columnNameList, ",\r\n"));
		printWriter.println(String.format("        FROM %s", tableName));
		List<String> whereList = new ArrayList<String>();
		for (Column column: columns){
			whereList.add("          (" + "P_IN_" + column.getColumnName() + " IS NULL OR " + column.getColumnName() + " LIKE '%' || " + "P_IN_"+ column.getColumnName() +" || '%')");
		}
		printWriter.println(String.format("        WHERE%s", StringUtils.join(whereList , "\r\n          AND")));
		printWriter.println(String.format("      )  "));
		printWriter.println(String.format("      WHERE 1 = 1"));	
		printWriter.println(String.format("        AND (P_IN_PAGE_SIZE IS NULL OR P_IN_CURRENT_PAGE IS NULL "));
		printWriter.println(String.format("               OR ROW_NUM "));
		printWriter.println(String.format("                 BETWEEN 1 + (P_IN_CURRENT_PAGE - 1) * P_IN_PAGE_SIZE "));
		printWriter.println(String.format("                 AND P_IN_CURRENT_PAGE * P_IN_PAGE_SIZE"));
		printWriter.println(String.format("        )"));
		printWriter.println(String.format("    ;"));
		printWriter.println(String.format("  END;"));
		printWriter.println(String.format("    "));
		printWriter.println(String.format("    "));
		printWriter.println(String.format("  "));

		printWriter.flush();
		printWriter.close();
		return procContent.toString();
	}
	
	public String genUpdateProc(String tableName, List<Column> columns ){
		StringWriter procContent = new StringWriter();
		PrintWriter printWriter = new PrintWriter(procContent);
		printWriter.println(String.format("  PROCEDURE %s_%s ( ", PackageConstant.UPDATE_PREFIX, tableName));
		List<String> paramList = new ArrayList<String>();
		for (Column column: columns){
			paramList.add(String.format("    P_IN_%-10s %-10s", column.getColumnName(), column.getDataType()));
		}
		printWriter.println(StringUtils.join(paramList, ",\r\n"));
		printWriter.println(String.format("  ) AS"));
		printWriter.println(String.format("  BEGIN"));
		printWriter.println(String.format("    UPDATE %s SET", tableName ));
		List<String> setList = new ArrayList<String>();
		for (Column column: columns){
			setList .add(String.format("         %s = P_IN_%s", column.getColumnName(), column.getColumnName()));
		}
		printWriter.println(StringUtils.join(setList , ",\r\n"));
		List<String> whereList = new ArrayList<String>();
		for(Column column: columns){
			if (column.getPk() == 1){
				whereList.add(String.format("%s = P_IN_%s", column.getColumnName(), column.getColumnName()) );
			} 
		}
		printWriter.println(String.format("    WHERE %s ;", StringUtils.join(whereList, ", \r\n    AND ")));
		printWriter.println(String.format("  END;"));
		printWriter.println(String.format("  "));
		printWriter.flush();
		printWriter.close();
		return procContent.toString();
	}
	
	public String genDeleteProc(String tableName, List<Column> columns ){
		StringWriter procContent = new StringWriter();
		PrintWriter printWriter = new PrintWriter(procContent);
		printWriter.println(String.format("  PROCEDURE %s_%s ( ", PackageConstant.DELETE_PREFIX, tableName));
		List<String> paramList = new ArrayList<String>();
		for (Column column: columns){
			if (column.getPk() == 1){
				paramList.add(String.format("    P_IN_%-10s %-10s", column.getColumnName(), column.getDataType()));
			}
		}
		printWriter.println(StringUtils.join(paramList, ",\r\n"));
		printWriter.println(String.format("  ) AS"));
		printWriter.println(String.format("  BEGIN"));
		printWriter.println(String.format("    DELETE %s", tableName));
		List<String> whereList = new ArrayList<String>();
		for (Column column: columns){
			if (column.getPk() == 1){
				whereList .add(String.format("%s = P_IN_%s", column.getColumnName(), column.getColumnName()));
			}
		}
		printWriter.println(String.format("      WHERE %s ;", StringUtils.join(whereList, " AND \r\n        ")));
		printWriter.println(String.format("  END;"));
		printWriter.println(String.format("  "));
		printWriter.flush();
		printWriter.close();
		return procContent.toString();
	}
}
