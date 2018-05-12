CREATE TABLE IF NOT EXISTS ${tableName} (
<#list fieldList as field>
	${field.columnName} ${field.columnDefinition} <#if  field?has_next>,<#else><#if primaryKey??>,</#if></#if>
</#list>
<#if primaryKey??>
	PRIMARY KEY(<#list primaryKey.fieldList as field>${field.columnName}<#if  field?has_next>,</#if></#list>)
</#if>
)