package com.techoffice.oracle.sqlmap.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techoffice.oracle.dao.TableDao;
import com.techoffice.oracle.model.Column;
import com.techoffice.oracle.sqlmap.generator.SqlMapGenerator;

@Service
public class SqlMapService {
	
	@Autowired
	private SqlMapGenerator sqlMapGenerator;
	
	@Autowired
	private TableDao tableDao;
	
	public void generateSqlMap(String tableName) throws IOException{
		
		List<Column> columns = tableDao.getTableColumnList(tableName);
		String sqlMap = sqlMapGenerator.generateSqlMap(tableName, columns);
		
		File output = new File("SqlMap");
		if(!output.exists()){
			output.mkdirs();
		}
		File sqlMapFile = new File(output, tableName + ".xml");
		FileWriter fileWriter = new FileWriter(sqlMapFile);
		fileWriter.write(sqlMap);
		fileWriter.flush();
		fileWriter.close();
	}
}
