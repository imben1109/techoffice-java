package ${metaMap.basePackage}.key;

public class ${javaClassName}Key{

<#list primaryKey.fieldList as field>
	private ${field.javaType} ${field.propertyName};
</#list>
	
<#list primaryKey.fieldList as field>
	public ${field.javaType} get${field.captialPropertyName}(){
		return this.${field.propertyName};
	}
	public void set${field.captialPropertyName}(${field.javaType} ${field.propertyName}){
		this.${field.propertyName} = ${field.propertyName};
	}
</#list>
}