package com.techoffice.data.generator;

import java.math.BigDecimal;
import java.util.Date;

import com.techoffice.data.generator.model.FieldData;
import com.techoffice.data.generator.type.BigDecimalGenerator;
import com.techoffice.data.generator.type.DateGenerator;
import com.techoffice.data.generator.type.IntegerGenerator;
import com.techoffice.data.generator.type.StringGenerator;
import com.techoffice.database.model.Field;

public class FieldDataGenerator {

	private BigDecimalGenerator bigDecimalGenerator = new BigDecimalGenerator();
	private DateGenerator dateGenerator = new DateGenerator();
	private IntegerGenerator integerGenerator = new IntegerGenerator();
	private StringGenerator stringGenerator = new StringGenerator();
	
	public FieldData generate(Field field){
		FieldData fieldData = new FieldData();
		Object value = null;
		if(	field.getJavaFullType().equals(String.class.getName()) ){
			value = stringGenerator.generate(field);
		}else if (field.getJavaFullType().equals(Integer.class.getName()) ){
			value = integerGenerator.generate(field);
		}else if (field.getJavaFullType().equals(BigDecimal.class.getName()) ){
			value = bigDecimalGenerator.generate(field);
		}else if (field.getJavaFullType().equals(Date.class.getName()) ){
			value = dateGenerator.generate(field);
		}
		fieldData.setValue(value);
		fieldData.setField(field);
		return fieldData;
	}
	
}
