package com.techoffice.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author Ben_c
 *
 */
public class RoutingDataSource extends AbstractRoutingDataSource{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public String dataSourceKey = "dataSource1";
	
	@Override
	protected Object determineCurrentLookupKey() {
		return dataSourceKey;
	}

	public void setDateSourceKey(String key){
		this.dataSourceKey = key;
		jdbcTemplate.setDataSource(this.determineTargetDataSource());
	}
	

}
