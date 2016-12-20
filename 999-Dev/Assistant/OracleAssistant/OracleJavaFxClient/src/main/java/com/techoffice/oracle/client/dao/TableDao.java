package com.techoffice.oracle.client.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.techoffice.oracle.client.model.Column;

@Repository
public class TableDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public List<String> selectTableList() {
		List<String> results = jdbcTemplate.queryForList("SELECT TABLE_NAME FROM USER_TABLES", String.class);
		return results;
	}
	
	public List<Column> getTableColumnList(String tableName, String schema){
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("TABLE_NAME", tableName);
		namedParameters.addValue("OWNER", schema);
		List<Column> list = namedParameterJdbcTemplate.query("SELECT COLUMN_NAME, DATA_TYPE, DATA_LENGTH FROM USER_TAB_COLS WHERE TABLE_NAME = :TABLE_NAME AND OWNER = :OWNER", 
			namedParameters, new RowMapper<Column>(){
				public Column mapRow(ResultSet rs, int rowNum) throws SQLException {
					Column column = new Column();
					column.setColumnName(rs.getString("COLUMN_NAME"));
					column.setDataType(rs.getString("DATA_TYPE"));
					column.setDataLength(rs.getInt("DATA_LENGTH"));
					return column;
				}
			}
		);
		return list;
	}
	
	public List<Column> getTableColumnList(String tableName){
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("TABLE_NAME", tableName);
		List<Column> list = namedParameterJdbcTemplate.query("SELECT COLUMN_NAME, DATA_TYPE, DATA_LENGTH FROM USER_TAB_COLS WHERE TABLE_NAME = :TABLE_NAME", 
			namedParameters, new RowMapper<Column>(){
				public Column mapRow(ResultSet rs, int rowNum) throws SQLException {
					Column column = new Column();
					column.setColumnName(rs.getString("COLUMN_NAME"));
					column.setDataType(rs.getString("DATA_TYPE"));
					column.setDataLength(rs.getInt("DATA_LENGTH"));
					return column;
				}
			}
		);
		return list;
	}
}
