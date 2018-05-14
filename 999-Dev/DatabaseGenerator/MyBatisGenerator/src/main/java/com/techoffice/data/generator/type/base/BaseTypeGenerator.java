package com.techoffice.data.generator.type.base;

import com.techoffice.database.model.Field;

public abstract class BaseTypeGenerator<T> {

	public abstract T generate(Field field);
}
