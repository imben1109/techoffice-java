	<delete id="delete">
		DELETE FROM ${tableName} 
		WHERE 1=1
	<#list primaryKey.fieldList as field>
			AND ${field.columnName} = ${"#{" + field.propertyName + "}"}
	</#list>
	</delete>