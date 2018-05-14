package com.techoffice.data.generator.type;

import com.techoffice.data.generator.type.base.BaseTypeGenerator;
import com.techoffice.database.model.Field;

public class IntegerGenerator extends BaseTypeGenerator<Integer> {

	private Integer sequence = 0;
	
	@Override
	public Integer generate(Field field) {
		if (field.isKey()){
			sequence++;
			return sequence;
		}
		return 1;
	}

}
