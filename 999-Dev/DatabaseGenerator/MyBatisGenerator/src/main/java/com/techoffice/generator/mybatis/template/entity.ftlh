package ${metaMap.basePackage}.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ${javaClassName}{

<#list fieldList as field>
	private ${field.javaType} ${field.propertyName};
</#list>

<#list fieldList as field>
	public ${field.javaType} get${field.captialPropertyName}(){
		return this.${field.propertyName};
	}
	public void set${field.captialPropertyName}(${field.javaType} ${field.propertyName}){
		this.${field.propertyName} = ${field.propertyName};
	}
</#list>


}