package com.techoffice.data.generator.type;

import java.math.BigDecimal;

import com.techoffice.data.generator.type.base.BaseTypeGenerator;
import com.techoffice.database.model.Field;

public class BigDecimalGenerator extends BaseTypeGenerator<BigDecimal> {

	private Integer sequence = 0;
	
	@Override
	public BigDecimal generate(Field field) {
		if (field.isKey()){
			sequence++;
			return BigDecimal.valueOf(sequence);
		}
		return BigDecimal.valueOf(0);
	}

}
