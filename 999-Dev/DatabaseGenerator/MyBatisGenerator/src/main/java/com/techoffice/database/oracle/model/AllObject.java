package com.techoffice.database.oracle.model;

import java.math.BigDecimal;
import java.util.Date;

public class AllObject {

	private String owner               ;
	private String objectName          ;
	private String subobjectName       ;
	private BigDecimal objectId        ;
	private BigDecimal dataObjectId    ;
	private String objectType          ;
	private Date created               ;
	private Date lastDdlTime           ;
	private String timestamp           ;
	private String status              ;
	private String temporary           ;
	private String generated           ;
	private String secondary           ;
	private BigDecimal namespace       ;
	private String editionName         ;
	private String sharing             ;
	private String editionable         ;
	private String oracleMaintained    ;
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getObjectName() {
		return objectName;
	}
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	public String getSubobjectName() {
		return subobjectName;
	}
	public void setSubobjectName(String subobjectName) {
		this.subobjectName = subobjectName;
	}
	public BigDecimal getObjectId() {
		return objectId;
	}
	public void setObjectId(BigDecimal objectId) {
		this.objectId = objectId;
	}
	public BigDecimal getDataObjectId() {
		return dataObjectId;
	}
	public void setDataObjectId(BigDecimal dataObjectId) {
		this.dataObjectId = dataObjectId;
	}
	public String getObjectType() {
		return objectType;
	}
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getLastDdlTime() {
		return lastDdlTime;
	}
	public void setLastDdlTime(Date lastDdlTime) {
		this.lastDdlTime = lastDdlTime;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTemporary() {
		return temporary;
	}
	public void setTemporary(String temporary) {
		this.temporary = temporary;
	}
	public String getGenerated() {
		return generated;
	}
	public void setGenerated(String generated) {
		this.generated = generated;
	}
	public String getSecondary() {
		return secondary;
	}
	public void setSecondary(String secondary) {
		this.secondary = secondary;
	}
	public BigDecimal getNamespace() {
		return namespace;
	}
	public void setNamespace(BigDecimal namespace) {
		this.namespace = namespace;
	}
	public String getEditionName() {
		return editionName;
	}
	public void setEditionName(String editionName) {
		this.editionName = editionName;
	}
	public String getSharing() {
		return sharing;
	}
	public void setSharing(String sharing) {
		this.sharing = sharing;
	}
	public String getEditionable() {
		return editionable;
	}
	public void setEditionable(String editionable) {
		this.editionable = editionable;
	}
	public String getOracleMaintained() {
		return oracleMaintained;
	}
	public void setOracleMaintained(String oracleMaintained) {
		this.oracleMaintained = oracleMaintained;
	}
	
	
}
