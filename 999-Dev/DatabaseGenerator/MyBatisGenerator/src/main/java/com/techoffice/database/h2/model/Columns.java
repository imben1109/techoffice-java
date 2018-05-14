package com.techoffice.database.h2.model;

import com.techoffice.database.dao.config.annoation.ColumnName;
import com.techoffice.database.dao.config.annoation.DataLength;
import com.techoffice.database.dao.config.annoation.IsNullable;
import com.techoffice.database.dao.config.annoation.JdbcType;
import com.techoffice.database.dao.config.annoation.Precision;
import com.techoffice.database.dao.config.annoation.Scale;

public class Columns {
	private String  tableCatalog			;
	private String  tableSchema				;
	private String  tableName				;
	@ColumnName
	private String  columnName				;
	private Integer ordinalPosition			;
	private String  columnDefault			;
	@IsNullable
	private String  isNullable				;
	private Integer	dataType				;
	@DataLength
	private Integer	characterMaximumLength	;
	private Integer	characterOctetLength	;
	@Precision
	private Integer	numericPrecision		;
	private Integer	numericPrecisionRadix	;
	@Scale
	private Integer	numericScale			;
	private String  characterSetName		;
	private String  collationName			;
	@JdbcType
	private String  typeName				;
	private Integer	nullable				;
	private Integer	selectivity				;
	private String checkConstraint			;
	private String sequenceName			    ;
	private String remarks					;
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
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public Integer getOrdinalPosition() {
		return ordinalPosition;
	}
	public void setOrdinalPosition(Integer ordinalPosition) {
		this.ordinalPosition = ordinalPosition;
	}
	public String getColumnDefault() {
		return columnDefault;
	}
	public void setColumnDefault(String columnDefault) {
		this.columnDefault = columnDefault;
	}
	public String getIsNullable() {
		return isNullable;
	}
	public void setIsNullable(String isNullable) {
		this.isNullable = isNullable;
	}
	public Integer getDataType() {
		return dataType;
	}
	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}
	public Integer getCharacterMaximumLength() {
		return characterMaximumLength;
	}
	public void setCharacterMaximumLength(Integer characterMaximumLength) {
		this.characterMaximumLength = characterMaximumLength;
	}
	public Integer getCharacterOctetLength() {
		return characterOctetLength;
	}
	public void setCharacterOctetLength(Integer characterOctetLength) {
		this.characterOctetLength = characterOctetLength;
	}
	public Integer getNumericPrecision() {
		return numericPrecision;
	}
	public void setNumericPrecision(Integer numericPrecision) {
		this.numericPrecision = numericPrecision;
	}
	public Integer getNumericPrecisionRadix() {
		return numericPrecisionRadix;
	}
	public void setNumericPrecisionRadix(Integer numericPrecisionRadix) {
		this.numericPrecisionRadix = numericPrecisionRadix;
	}
	public Integer getNumericScale() {
		return numericScale;
	}
	public void setNumericScale(Integer numericScale) {
		this.numericScale = numericScale;
	}
	public String getCharacterSetName() {
		return characterSetName;
	}
	public void setCharacterSetName(String characterSetName) {
		this.characterSetName = characterSetName;
	}
	public String getCollationName() {
		return collationName;
	}
	public void setCollationName(String collationName) {
		this.collationName = collationName;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getNullable() {
		return nullable;
	}
	public void setNullable(Integer nullable) {
		this.nullable = nullable;
	}
	public Integer getSelectivity() {
		return selectivity;
	}
	public void setSelectivity(Integer selectivity) {
		this.selectivity = selectivity;
	}
	public String getCheckConstraint() {
		return checkConstraint;
	}
	public void setCheckConstraint(String checkConstraint) {
		this.checkConstraint = checkConstraint;
	}
	public String getSequenceName() {
		return sequenceName;
	}
	public void setSequenceName(String sequenceName) {
		this.sequenceName = sequenceName;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
