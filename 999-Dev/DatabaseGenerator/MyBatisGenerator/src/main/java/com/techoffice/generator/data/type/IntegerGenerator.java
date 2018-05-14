package com.techoffice.generator.data.type;

import com.techoffice.database.dao.model.Field;
import com.techoffice.generator.data.type.base.BaseTypeGenerator;

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
