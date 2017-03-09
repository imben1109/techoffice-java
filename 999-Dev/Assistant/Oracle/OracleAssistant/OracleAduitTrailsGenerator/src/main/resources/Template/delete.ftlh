<#ftl output_format="plainText">
CREATE OR REPLACE TRIGGER ${schema}.${triggerName} BEFORE DELETE
ON ${schema}.${tableName} FOR EACH ROW
BEGIN
    INSERT INTO ${auditSchema}.${auditTableName} ( 
<#list auditColumns as column>
		${column.columnName}<#sep>,</#sep>
</#list>
    ) VALUES ( 
<#list auditColumns as column>
		:OLD.${column.columnName}<#sep>,</#sep>
</#list>
    );
  END IF;
END;
/