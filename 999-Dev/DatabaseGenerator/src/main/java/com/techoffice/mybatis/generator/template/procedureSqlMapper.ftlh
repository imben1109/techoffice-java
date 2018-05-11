<select id="${methodName}" statementType="CALLABLE">
	{
		${pakcageName}.${procedureName}(
		<#list argumentList as argument>
			${"#{" + argument.argumentName + ", jdbcType=" + argument.jdbcType + ", javaType=" + argument.javaType + "}"}
		</#list>
		)
	}
</select>