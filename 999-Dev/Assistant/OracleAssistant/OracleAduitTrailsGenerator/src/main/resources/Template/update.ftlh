<#ftl output_format="plainText">
CREATE OR REPLACE TRIGGER ${schema}.${triggerName} BEFORE UPDATE
ON ${schema}.${tableName} FOR EACH ROW
BEGIN
    INSERT INTO ${auditSchema}.${auditTableName} ( 
	<#list auditColumns as column>
		${column.columnName}<#sep>, </#sep>
	</#list>
    ) VALUES ( 
<#list auditColumns as column>
		:NEW.${column.columnName}<#sep>, </#sep>
</#list>
    );
    -- Before Image
    INSERT INTO ${auditSchema}.${auditTableName} ( 
<#list auditColumns as column>
		${column.columnName}<#sep>, </#sep>
</#list>
    ) VALUES ( 
<#list auditColumns as column>
		:OLD.${column.columnName}<#sep>, </#sep>
</#list>
    );
END;
/