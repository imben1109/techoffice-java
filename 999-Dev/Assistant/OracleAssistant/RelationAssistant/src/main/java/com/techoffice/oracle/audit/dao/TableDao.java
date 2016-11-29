package com.techoffice.oracle.audit.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class TableDao {
	
	@Autowired
	@Qualifier("namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public void getTableColumnList(String tableName, String schema){
		String sql = 	" SELECT TABLE_NAME,                                                        " + 
						"   (SELECT LISTAGG(COLUMN_NAME, ', ')                                      " + 
						"     WITHIN GROUP (ORDER BY POSITION)                                      " + 
						"     FROM USER_CONS_COLUMNS                                                " + 
						"     WHERE USER_CONS_COLUMNS.CONSTRAINT_NAME = P.CONSTRAINT_NAME           " + 
						"       AND POSITION IS NOT NULL                                            " + 
						"     GROUP BY CONSTRAINT_NAME, TABLE_NAME                                  " + 
						"   ) AS PRIMARY_KEY_COLUMNS,                                               " + 
						"   (SELECT LISTAGG(TABLE_NAME, ', ')                                       " + 
						"     WITHIN GROUP (ORDER BY TABLE_NAME)                                    " + 
						"     FROM USER_CONSTRAINTS R                                               " + 
						"     WHERE R.CONSTRAINT_TYPE = 'R'                                         " + 
						"     AND R.R_CONSTRAINT_NAME = P.CONSTRAINT_NAME                           " + 
						"     GROUP BY R.R_CONSTRAINT_NAME                                          " + 
						"   )AS USED_TABLES                                                         " + 
						" FROM USER_CONSTRAINTS P                                                   " + 
						" WHERE P.CONSTRAINT_TYPE = 'P'                                             " + 
						"   AND TABLE_NAME IN (SELECT TABLE_NAME FROM USER_TABLES)                  " + 
						"   AND CONSTRAINT_NAME IN (SELECT R_CONSTRAINT_NAME FROM USER_CONSTRAINTS) " + 
						"   AND TABLE_NAME LIKE :TABLE_NAME'                                        " ;


	}
	
	

}
