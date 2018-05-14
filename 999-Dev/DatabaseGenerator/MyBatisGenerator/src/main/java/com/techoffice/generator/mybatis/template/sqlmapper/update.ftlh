	<update id="update">
		UPDATE TEST SET
<#list fieldList as field>
			${field.columnName} = ${"#{" + field.propertyName + "}"}<#if field?has_next>,</#if>
</#list>				
		WHERE 1=1
	<#list primaryKey.fieldList as field>
			AND ${field.columnName} = ${"#{" + field.propertyName + "}"}
	</#list>
	</update>
	