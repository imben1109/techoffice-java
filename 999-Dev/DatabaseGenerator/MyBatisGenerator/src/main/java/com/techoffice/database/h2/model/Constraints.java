package com.techoffice.database.h2.model;

public class Constraints {
	private String	  constraintCatalog  ;
	private String	  constraintSchema   ;
	private String	  constraintName     ;
	private String	  constraintType     ;
	private String	  tableCatalog       ;
	private String	  tableSchema        ;
	private String	  tableName          ;
	private String	  uniqueIndexName    ;
	private String	  checkExpression    ;
	private String	  columnList         ;
	private String	  remarks            ;
	private String	  sql                ;
	private Integer	  id                 ;
	public String getConstraintCatalog() {
		return constraintCatalog;
	}
	public void setConstraintCatalog(String constraintCatalog) {
		this.constraintCatalog = constraintCatalog;
	}
	public String getConstraintSchema() {
		return constraintSchema;
	}
	public void setConstraintSchema(String constraintSchema) {
		this.constraintSchema = constraintSchema;
	}
	public String getConstraintName() {
		return constraintName;
	}
	public void setConstraintName(String constraintName) {
		this.constraintName = constraintName;
	}
	public String getConstraintType() {
		return constraintType;
	}
	public void setConstraintType(String constraintType) {
		this.constraintType = constraintType;
	}
	public String getTableCatalog() {
		return tableCatalog;
	}
	public void setTableCatalog(String tableCatalog) {
		this.tableCatalog = tableCatalog;
	}
	public String getTableSchema() {
		return tableSchema;
	}
	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getUniqueIndexName() {
		return uniqueIndexName;
	}
	public void setUniqueIndexName(String uniqueIndexName) {
		this.uniqueIndexName = uniqueIndexName;
	}
	public String getCheckExpression() {
		return checkExpression;
	}
	public void setCheckExpression(String checkExpression) {
		this.checkExpression = checkExpression;
	}
	public String getColumnList() {
		return columnList;
	}
	public void setColumnList(String columnList) {
		this.columnList = columnList;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
