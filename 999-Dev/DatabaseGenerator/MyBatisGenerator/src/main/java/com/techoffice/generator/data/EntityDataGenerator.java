package com.techoffice.generator.data;

import java.util.ArrayList;
import java.util.List;

import com.techoffice.database.dao.model.Entity;
import com.techoffice.database.dao.model.Field;
import com.techoffice.database.dao.registry.EntityDaoRegistry;
import com.techoffice.database.h2.dao.H2EntityDao;
import com.techoffice.generator.data.model.EntityData;
import com.techoffice.generator.data.model.FieldData;
import com.techoffice.generator.freemarker.util.FreemakerUtil;

public class EntityDataGenerator {

	private EntityDataGenerator(){}
	private static FieldDataGenerator fieldDataGenerator = FieldDataGenerator.getInstance(); 
	
	public String generate(Entity entity){
		EntityData entityData = new EntityData();
		entityData.setEntity(entity);
		List<FieldData> fieldDataList = new ArrayList<FieldData>();
		for (Field field: entity.getFieldList()){
			FieldData fieldData = fieldDataGenerator.generate(field);
			fieldDataList.add(fieldData);
		}
		entityData.setFieldDataList(fieldDataList);
		return FreemakerUtil.generate(this.getClass(), entityData);
	}
	

}
