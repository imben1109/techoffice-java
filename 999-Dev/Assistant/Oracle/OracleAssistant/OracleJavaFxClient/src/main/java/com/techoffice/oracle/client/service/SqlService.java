package com.techoffice.oracle.client.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techoffice.oracle.client.dao.SqlDao;
import com.techoffice.oracle.client.dao.TableDao;

@Service
public class SqlService {
	
	@Autowired
	private SqlDao sqlDao;
	
	public List<Map<String, Object>> executeSql(String sql){
		List<Map<String, Object>> results = sqlDao.execute(sql);
		return results;
	}
	

}
