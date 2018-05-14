package com.techoffice.data.generator;

import java.util.ArrayList;
import java.util.List;

import com.techoffice.data.generator.model.EntityData;
import com.techoffice.data.generator.model.FieldData;
import com.techoffice.database.model.Entity;
import com.techoffice.database.model.Field;
import com.techoffice.database.registry.EntityDaoRegistry;
import com.techoffice.freemarker.util.FreemakerUtil;
import com.techoffice.h2.dao.H2EntityDao;

public class EntityDataGenerator {

	private EntityDataGenerator(){}
	
	public String generate(Entity entity){
		EntityData entityData = new EntityData();
		entityData.setEntity(entity);
		List<FieldData> fieldDataList = new ArrayList<FieldData>();
		for (Field field: entity.getFieldList()){
			FieldData fieldData = new FieldData();
			fieldData.setField(field);
			fieldDataList.add(fieldData);
		}
		entityData.setFieldDataList(fieldDataList);
		return FreemakerUtil.generate(this.getClass(), entityData);
	}
	
	public static void main(String[] args){
		Entity entity = EntityDaoRegistry.getEntityDao(H2EntityDao.class).getEntity("TEST");
		EntityDataGenerator entityDataGenerator = new EntityDataGenerator();
		String content = entityDataGenerator.generate(entity);
		System.out.println(content);
	}
}
