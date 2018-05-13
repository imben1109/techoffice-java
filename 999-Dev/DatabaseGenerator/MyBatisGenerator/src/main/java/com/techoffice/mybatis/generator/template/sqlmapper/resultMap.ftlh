	<resultMap id="${javaClassName}ResultMap" type="${javaClassName}">
	<#list fieldList as field>
  		<result property="${field.propertyName}" column="${field.columnName}"/>
	</#list>
	</resultMap>