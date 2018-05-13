	<select id="find" resultMap="${uncaptialJavaClassName}ResultMap">
		SELECT * FROM TEST 
		WHERE 1=1
	<#list primaryKey.fieldList as field>
			AND ${field.columnName} = ${"#{" + field.propertyName + "}"}
	</#list>
	</select>