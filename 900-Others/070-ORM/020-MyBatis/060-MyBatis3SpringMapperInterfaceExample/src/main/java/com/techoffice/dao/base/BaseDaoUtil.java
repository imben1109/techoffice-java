package com.techoffice.dao.base;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import com.google.common.base.CaseFormat;

public class BaseDaoUtil {

	private BaseDaoUtil(){}
	
	public static final String KEY_COLUMNLIST = "keyColumnList";
	public static final String COLUMNLIST = "columnList";
	
	public static <T> List<Column> getKeyColumnList(T entity){
		try{
			List<Column> keyColumnList = new ArrayList<Column>();
			List<Field> keyFiledList = FieldUtils.getFieldsListWithAnnotation(entity.getClass(), Key.class);
			if (keyFiledList.size() == 0){
				throw new BaseDaoException("Entity do not contain key column");
			}
			for (Field keyField: keyFiledList){
				Column column = new Column();
				String fieldName = keyField.getName();
				column.setFieldName(fieldName);
				column.setValue(BeanUtils.getProperty(entity, fieldName));
				String columnName = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, fieldName);
				column.setColumnName(columnName);
				keyColumnList.add(column);
			}
			return keyColumnList;
		} catch (Exception e){
			throw new BaseDaoException(e);
		}
	}
	
	public static <T> List<Column> getColumnList(T entity){
		try{
			List<Column> columnList = new ArrayList<Column>();
			List<Field> filedList = FieldUtils.getAllFieldsList(entity.getClass());
			if (filedList.size() == 0){
				throw new BaseDaoException("Entity do not contain any column");
			}
			for (Field field: filedList){
				Column column = new Column();
				String fieldName = field.getName();
				column.setFieldName(fieldName);
				column.setValue(BeanUtils.getProperty(entity, fieldName));
				String columnName = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, fieldName);
				column.setColumnName(columnName);
				columnList.add(column);
			}
			return columnList;
		} catch (Exception e){
			throw new BaseDaoException(e);
		}
	}
	
	public static <T> Map<String, Object> getParameterWithKeyColumnList(T entity, Map<String, Object> map){
		map.put(KEY_COLUMNLIST, getKeyColumnList(entity));
		return map;
	}
	
	public static <T> Map<String, Object> getParameterWithColumnList(T entity, Map<String, Object> map){
		map.put(COLUMNLIST, getColumnList(entity));
		return map;
	}
	
	public static <T> Map<String, Object> getParameterWithFullColumnList(T entity, Map<String, Object> map){
		map.put(KEY_COLUMNLIST, getKeyColumnList(entity));
		map.put(COLUMNLIST, getColumnList(entity));
		return map;
	}
	
	public static <T> T convertResultMapToEntity(Map<String, Object> resultMap, Class<T> clazz){
		try{
			T entity = clazz.newInstance();
			List<Field> fieldList = FieldUtils.getAllFieldsList(clazz);
			for (Field field: fieldList){
				String fieldName = field.getName();
				String columnName = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, fieldName);
				Object value = resultMap.get(columnName);
				BeanUtils.setProperty(entity, fieldName, value);
			}
			return entity;
		} catch (Exception e){
			throw new BaseDaoException(e);
		}
	}
	
	public static <T> List<T> convertResultMapListToEntityList(List<Map<String, Object> > resultMapList, Class<T> clazz){
		List<T> entityList = new ArrayList<T>();
		for(Map<String, Object> resultMap: resultMapList){
			T entity = convertResultMapToEntity(resultMap, clazz);
			entityList.add(entity);
		}
		return entityList;
	}
}
