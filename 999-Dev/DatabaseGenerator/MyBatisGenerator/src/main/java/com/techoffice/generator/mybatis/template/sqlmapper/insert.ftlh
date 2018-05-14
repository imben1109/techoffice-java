	<insert if="insert">
		INSERT INTO ${tableName}(
		<#list fieldList as field>
			${field.columnName}<#if field?has_next>,</#if>
		</#list>
		)values(
		<#list fieldList as field>
			${"#{" + field.propertyName + "}"}<#if field?has_next>,</#if>
		</#list>
		)
	
	</insert>