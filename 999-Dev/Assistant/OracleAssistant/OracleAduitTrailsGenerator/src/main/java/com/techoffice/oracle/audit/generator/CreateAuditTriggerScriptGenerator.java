package com.techoffice.oracle.audit.generator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techoffice.oracle.audit.config.ApplConfig;
import com.techoffice.oracle.audit.config.FreeMarkerConfiguration;
import com.techoffice.oracle.audit.dao.TableDao;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

@Component
public class CreateAuditTriggerScriptGenerator {
	
	@Autowired
	private TableDao tableDao;
	
	public static enum Type{INSERT, UPDATE, DELETE};
	
	public void generate() throws URISyntaxException, IOException, TemplateException{
		generate(CreateAuditTriggerScriptGenerator.Type.INSERT);
		generate(CreateAuditTriggerScriptGenerator.Type.UPDATE);
		generate(CreateAuditTriggerScriptGenerator.Type.DELETE);
	}
	
	public void generate(Type type) throws URISyntaxException, IOException, TemplateException{
		String schema = ApplConfig.getString("schema");
		String tableName = ApplConfig.getString("tableName");
		String auditSchema = ApplConfig.getString("auditTable.schema");
		String auditTableName = ApplConfig.getString("auditTable.tableName");
		
		String triggerName = null;
		if (type.equals(Type.INSERT)){
			triggerName = ApplConfig.getString("trigger.insert.name");
		}else if (type.equals(Type.DELETE)){
			triggerName = ApplConfig.getString("trigger.delete.name");
		}else if (type.equals(Type.UPDATE)){
			triggerName = ApplConfig.getString("trigger.update.name");
		}
		
        FreeMarkerConfiguration cfg = new FreeMarkerConfiguration();
        
        Template temp = null;
		if (type.equals(Type.INSERT)){
			temp = cfg.getTemplate("insert.ftlh");
		}else if (type.equals(Type.UPDATE)){
			temp = cfg.getTemplate("update.ftlh");
		}else if (type.equals(Type.DELETE)){
			temp = cfg.getTemplate("delete.ftlh");
		}
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("schema", schema);
        map.put("auditSchema", auditSchema);
        map.put("tableName", tableName);
        map.put("auditTableName", auditTableName);
        map.put("triggerName", triggerName);
        map.put("auditColumns", tableDao.getTableColumnList(tableName, schema));
        
        Map<String, String> specialColumnMap = new HashMap<String, String>();
        specialColumnMap.put(ApplConfig.getString("auditTable.id.name"), 
        		ApplConfig.getString("auditTable.id.value"));
        specialColumnMap.put(ApplConfig.getString("auditTable.id.name"), 
        		ApplConfig.getString("auditTable.id.value"));
        specialColumnMap.put(ApplConfig.getString("auditTable.id.name"), 
        		ApplConfig.getString("auditTable.id.value"));
        specialColumnMap.put(ApplConfig.getString("auditTable.id.name"), 
        		ApplConfig.getString("auditTable.id.value"));
        map.put("specialColumnMap", specialColumnMap);
        File file = new File(triggerName+".sql");
        Writer out = new OutputStreamWriter(System.out);
        temp.process(map, out);
        System.out.println("Trigger File Generated: " + file.getAbsolutePath());
	}
}
