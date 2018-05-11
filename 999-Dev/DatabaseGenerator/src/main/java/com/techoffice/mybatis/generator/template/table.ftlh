CREATE TABLE IF NOT EXISTS ${tableName} (
<#list fieldList as field>
	${field.columnName} ${field.columnDefinition} <#if  field?has_next>,</#if>
</#list>	
)