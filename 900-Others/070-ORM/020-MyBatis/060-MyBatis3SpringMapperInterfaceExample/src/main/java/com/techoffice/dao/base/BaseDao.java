package com.techoffice.dao.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public abstract class BaseDao<T> {
	
	@Autowired
	private SqlSession sqlSession;
	
	protected abstract Class<T> getEntityClass();
	
	public String getSimpleName(){
		return getEntityClass().getSimpleName();
	}
	
	protected Map<String, Object> getBaseParameter(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("table", this.getSimpleName());
		return map;
	}
		
	public SqlSession getSqlSession(){
		return this.sqlSession;
	}
	
	@Transactional
	public int insert(T entity){
		Map<String, Object> map = this.getBaseParameter();
		map = BaseDaoUtil.getParameterWithColumnList(entity, map);
		return sqlSession.insert("base.insert", map);
	}
	
	@Transactional
	public int update(T entity) {
		Map<String, Object> map = this.getBaseParameter();
		map = BaseDaoUtil.getParameterWithFullColumnList(entity, map);
		return sqlSession.update("base.update", map);
	}
	
	@Transactional
	public List<T> select(){
		List<Map<String, Object>> resultMapList =  this.sqlSession.selectList("base.select", this.getBaseParameter());
		return BaseDaoUtil.convertResultMapListToEntityList(resultMapList, getEntityClass());
	}
	
	@Transactional
	public int delete(T entity){
		Map<String, Object> map = this.getBaseParameter();
		map = BaseDaoUtil.getParameterWithKeyColumnList(entity, map);
		return sqlSession.insert("base.delete", map);
	}
	
}
