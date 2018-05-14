package com.techoffice.generator.data.type;

import java.util.Date;

import com.techoffice.database.dao.model.Field;
import com.techoffice.generator.data.type.base.BaseTypeGenerator;

public class DateGenerator extends BaseTypeGenerator<Date> {

	@Override
	public Date generate(Field field) {
		return new Date();
	}

}
