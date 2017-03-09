package com.techoffice.oracle.audit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.oracle.audit.model.Column;

@Transactional
@Repository
public class TableDao {
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public List<Column> getTableColumnList(String tableName, String schema){
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("TABLE_NAME", tableName);
		namedParameters.addValue("OWNER", schema);
		List<Column> list = namedParameterJdbcTemplate.query("SELECT COLUMN_NAME, DATA_TYPE, DATA_LENGTH FROM ALL_TAB_COLS WHERE TABLE_NAME = :TABLE_NAME AND OWNER = :OWNER", 
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
