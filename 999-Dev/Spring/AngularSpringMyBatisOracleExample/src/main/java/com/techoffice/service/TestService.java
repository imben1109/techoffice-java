package com.techoffice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techoffice.dao.TestDao;
import com.techoffice.model.Test;

@Service
public class TestService {

	@Autowired
	private TestDao testDao;
	
	public List<Test> search(){
		Map<String, Object> map = new HashMap<String, Object>();
		testDao.search(map);
		List<Test> list = (List<Test>) map.get("result");
		return list;
	}
}
