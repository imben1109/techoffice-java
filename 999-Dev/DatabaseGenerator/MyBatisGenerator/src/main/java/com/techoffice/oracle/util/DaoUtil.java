package com.techoffice.oracle.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.techoffice.oracle.exception.DaoException;
import com.techoffice.util.StringUtil;

public class DaoUtil {

	public static <T> List<T> list(Class<T> clazz, String query){
		List<T> resultList = new ArrayList<T>();
		try {
			Statement stmt = DatabaseUtil.getConnection().createStatement();
			ResultSet resultSet = stmt.executeQuery(query);
			while(resultSet.next()){
				ResultSetMetaData metaData = resultSet.getMetaData();
				int columnCount = metaData.getColumnCount();
				T obj = clazz.newInstance();
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
