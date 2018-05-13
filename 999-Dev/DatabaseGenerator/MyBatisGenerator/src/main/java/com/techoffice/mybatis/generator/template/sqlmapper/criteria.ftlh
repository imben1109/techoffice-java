	<sql ="${uncaptialJavaClassName}Criteria">
	<#list fieldList as field>
		<if test="${field.propertyName} != null and ${field.propertyName} != ''">
			AND ${field.columnName} = ${field.propertyName}
		</if>
	</#list>
	</sql>