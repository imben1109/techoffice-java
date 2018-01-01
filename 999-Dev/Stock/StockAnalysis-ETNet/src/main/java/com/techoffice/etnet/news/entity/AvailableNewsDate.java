package com.techoffice.etnet.news.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class AvailableNewsDate {

	@Id
	private Date postDate;
	private String dateStr;
	private String url;
	private String runInd;
	
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public String getDateStr() {
		return dateStr;
	}
	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRunInd() {
		return runInd;
	}
	public void setRunInd(String runInd) {
		this.runInd = runInd;
	}
	
	
}
