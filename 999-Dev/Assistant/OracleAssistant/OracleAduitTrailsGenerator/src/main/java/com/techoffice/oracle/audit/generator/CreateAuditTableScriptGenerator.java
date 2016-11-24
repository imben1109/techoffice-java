package com.techoffice.oracle.audit.generator;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techoffice.oracle.audit.config.ApplConfig;
import com.techoffice.oracle.audit.config.FreeMarkerConfiguration;
import com.techoffice.oracle.audit.constant.ColumnConstant;
import com.techoffice.oracle.audit.dao.TableDao;
import com.techoffice.oracle.audit.model.Column;

import freemarker.template.Template;
import freemarker.template.TemplateException;

@Component
public class CreateAuditTableScriptGenerator {
	
	@Autowired
	private TableDao tableDao;
	
	public void generate() throws IOException, TemplateException{
		String tableName = ApplConfig.getString("tableName");
		List<Column> columnList = tableDao.getTableColumnList(tableName, ApplConfig.getString("schema"));
        FreeMarkerConfiguration cfg = new FreeMarkerConfiguration();
        Map<String, Object> map = createParameterMap();
        Writer out = new OutputStreamWriter(System.out);
        Template temp = cfg.getTemplate("AuditTableDdl.ftlh");
        temp.process(map, out);
	}
	
	private Map<String, Object> createParameterMap(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("auditSchema", ApplConfig.getString("auditTable.schema"));
        map.put("auditTableName", ApplConfig.getString("auditTable.tableName"));
        map.put("auditColumns", getAuditColumn());
        map.put("auditSequence", ApplConfig.getString("auditTable.id.sequence"));
        return map;
	}
	
	private List<Column> getAuditColumn(){
		List<Column> columns = tableDao.getTableColumnList(ApplConfig.getString("tableName"), ApplConfig.getString("schema"));
        columns.add(new Column(ApplConfig.getString("auditTable.id.column"), 
        		ColumnConstant.NUMBER, 
        		ApplConfig.getInt("auditTable.id.size")));
        columns.add(new Column(ApplConfig.getString("auditTable.type.column"), 
        		ColumnConstant.VARCHAR2, 
        		ApplConfig.getInt("auditTable.type.size")));
        columns.add(new Column(ApplConfig.getString("auditTable.user.column"), 
        		ColumnConstant.VARCHAR2, 
        		ApplConfig.getInt("auditTable.user.size")));
        columns.add(new Column(ApplConfig.getString("auditTable.progId.column"), 
        		ColumnConstant.VARCHAR2, 
        		ApplConfig.getInt("auditTable.progId.size")));
        columns.add(new Column(ApplConfig.getString("auditTable.executionTime.column"), ColumnConstant.DATE));
        return columns;
	}
}
