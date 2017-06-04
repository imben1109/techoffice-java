package com.techoffice.oracle.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techoffice.oracle.model.Column;

@Repository
public class TableDao {
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Transactional
	public List<Column> getTableColumnList(String tableName){
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("TABLE_NAME", tableName);
		List<Column> list = namedParameterJdbcTemplate.query("SELECT TABLE_NAME, COLUMN_NAME, DATA_TYPE, DATA_LENGTH, P_KEY, NULLABLE, DATA_SCALE FROM TABLE_META WHERE TABLE_NAME = :TABLE_NAME", 
			namedParameters, new RowMapper<Column>(){
				public Column mapRow(ResultSet rs, int rowNum) throws SQLException {
					Column column = new Column();
					column.setTableName(rs.getString("TABLE_NAME"));
					column.setColumnName(rs.getString("COLUMN_NAME"));
					column.setDataType(rs.getString("DATA_TYPE"));
					column.setNullable(rs.getString("NULLABLE"));
					column.setDataLength(rs.getInt("DATA_LENGTH"));
					column.setDataScale(rs.getInt("DATA_SCALE"));
					column.setPk(rs.getInt("P_KEY"));
					return column;
				}
			}
		);
		return list;
	}
	

}
