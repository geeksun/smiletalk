package com.bird.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Description 日志对象
 * @author Administrator
 * 2012-9-16
 */
public class LogBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3606986764997360541L;
	private String userName;
	private Date createDate;
	private String content;
	private String operation;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
}
