package com.techoffice.data.generator.type;

import java.util.Date;

import com.techoffice.data.generator.type.base.BaseTypeGenerator;
import com.techoffice.database.model.Field;

public class DateGenerator extends BaseTypeGenerator<Date> {

	@Override
	public Date generate(Field field) {
		return new Date();
	}

}
