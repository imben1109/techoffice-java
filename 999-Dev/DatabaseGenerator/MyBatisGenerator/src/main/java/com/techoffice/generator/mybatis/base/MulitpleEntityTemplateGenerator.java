package com.techoffice.generator.mybatis.base;

import java.io.File;
import java.util.List;

import com.techoffice.database.dao.model.Entity;

public abstract class MulitpleEntityTemplateGenerator {

	public abstract List<File> generate(Entity entity);

}
