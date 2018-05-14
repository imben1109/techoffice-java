package com.techoffice.generator.data.type.base;

import com.techoffice.database.dao.model.Field;

public abstract class BaseTypeGenerator<T> {

	public abstract T generate(Field field);
}
