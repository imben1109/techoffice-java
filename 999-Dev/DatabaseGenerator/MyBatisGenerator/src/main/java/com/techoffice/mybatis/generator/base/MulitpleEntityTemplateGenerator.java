package com.techoffice.mybatis.generator.base;

import java.io.File;
import java.util.List;

import com.techoffice.database.model.Entity;

public abstract class MulitpleEntityTemplateGenerator {

	public abstract List<File> generate(Entity entity);

}
