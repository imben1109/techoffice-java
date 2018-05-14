package com.techoffice.data.generator.type.registry;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.techoffice.data.generator.type.BigDecimalGenerator;
import com.techoffice.data.generator.type.DateGenerator;
import com.techoffice.data.generator.type.IntegerGenerator;
import com.techoffice.data.generator.type.StringGenerator;
import com.techoffice.data.generator.type.base.BaseTypeGenerator;

public class TypeGeneratorRegistry {

	private static Map<Class<?>, BaseTypeGenerator<?>> map = new HashMap<Class<?>, BaseTypeGenerator<?>>();
	static {
		map.put(String.class, new StringGenerator());
		map.put(Date.class, new DateGenerator());
		map.put(Integer.class, new IntegerGenerator());
		map.put(BigDecimal.class, new BigDecimalGenerator());
	}
	
	private TypeGeneratorRegistry(){}
	
	public static <T> BaseTypeGenerator<T> getTypeGenerator(Class<T> clazz){
		BaseTypeGenerator<?> baseTypeGenerator = map.get(clazz);
		if (baseTypeGenerator == null){
			throw new RuntimeException("Failed to get Type Generator from Registry: " + clazz.getName());
		}
		Type type = baseTypeGenerator.getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType){
			ParameterizedType parameterizedType = (ParameterizedType) type;
			if (parameterizedType.getActualTypeArguments()[0] == clazz){
				@SuppressWarnings("unchecked")
				BaseTypeGenerator<T> typeGenerator = (BaseTypeGenerator<T>) baseTypeGenerator;
				return typeGenerator;
			}
		}
		return null;
	}
	
	public static void main(String[] args){

	}
	
}
