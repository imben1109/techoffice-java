CREATE TABLE ${auditSchema}.${auditTableName} (
<#list auditColumns as column>
	${column.toString()}<#sep>,</#sep>
</#list>	
);

CREATE SEQUENCE ${auditSchema}.${auditSequence} START WITH 1 INCREMENT BY 1;

/
