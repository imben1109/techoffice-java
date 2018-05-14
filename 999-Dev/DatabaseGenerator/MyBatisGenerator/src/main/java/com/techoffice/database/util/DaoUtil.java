package com.techoffice.database.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.techoffice.database.connection.DatabaseConnection;
import com.techoffice.database.exception.DaoException;
import com.techoffice.database.registry.DatabaseConnectionRegistry;

public class DaoUtil {

	public static <T> List<T> list(Class<? extends DatabaseConnection> dbConnClazz, 
		Class<?> daoClazz, Class<T> instanceClazz, String query){
		Map<String, List<?>> cache = DaoQueryCacheUtil.getCache(daoClazz);
		@SuppressWarnings("unchecked")
		List<T> resultList = (List<T>) cache.get(query);
		if (resultList == null ){
			resultList = list(dbConnClazz, instanceClazz, query);
		}
		return resultList ;
	}
	
	private static <T> List<T> list(Class<? extends DatabaseConnection> dbConnClazz, 
			Class<T> instanceClazz, String query){
		List<T> resultList = new ArrayList<T>();
		try {
			DatabaseConnection conn = DatabaseConnectionRegistry.getDatabaseConnection(dbConnClazz);
			Statement stmt = conn.getConnection().createStatement();
			ResultSet resultSet = stmt.executeQuery(query);
			while(resultSet.next()){
				ResultSetMetaData metaData = resultSet.getMetaData();
				int columnCount = metaData.getColumnCount();
				T obj = instanceClazz.newInstance();
				for (int i=0; i<columnCount; i++){
					try{
						String propertyName = StringUtil.upperUnderscoreToLowerCamel(metaData.getColumnName(i+1));
						if (resultSet.getObject(i+1) != null){
							BeanUtils.setProperty(obj, propertyName, resultSet.getObject(i+1));
						}
					}catch(Exception e){
						throw new DaoException(e);
					}
				}
				resultList.add(obj);
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}

		return resultList;
	}
	
}
