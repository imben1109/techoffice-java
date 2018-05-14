package com.techoffice.generator.data.type;

import java.math.BigDecimal;

import com.techoffice.database.dao.model.Field;
import com.techoffice.generator.data.type.base.BaseTypeGenerator;

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
