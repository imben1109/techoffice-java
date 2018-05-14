INSERT INTO ${entity.tableName}(
<#list fieldDataList as fieldData>
	${fieldData.field.columnName}<#if fieldData?has_next>,</#if>
</#list>
)values(
<#list fieldDataList as fieldData>
	${"#{" + fieldData.field.propertyName + "}"}<#if fieldData?has_next>,</#if>
</#list>
);