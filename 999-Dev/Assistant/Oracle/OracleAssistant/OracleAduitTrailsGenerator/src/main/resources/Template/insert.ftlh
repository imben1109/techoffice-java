<#ftl output_format="plainText">
CREATE OR REPLACE TRIGGER ${schema}.${triggerName} AFTER INSERT
ON ${schema}.${tableName} FOR EACH ROW
DECLARE
BEGIN
      INSERT INTO ${auditSchema}.${auditTableName} ( 
<#list auditColumns as column>
		${column.columnName}<#sep>,</#sep>
</#list>
    ) VALUES ( 
<#list auditColumns as column>
		:NEW.${column.columnName}<#sep>,</#sep>
</#list>
    );
END;
/