
public class ${javaClassName}{

<#list fieldList as field>
	private ${field.javaType} ${field.propertyName};
</#list>

}