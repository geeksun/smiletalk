package com.bird.domain;

import java.io.Serializable;

/**
 * @author jzq
 * iTalk 用户
 * 2009-11-4
 */
public class UserBean  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7807593836654741375L;
	private long userId;
	private String userName;
	private String password;
	private String email;
	private String isActive;//激活状态-0:未激活1：激活
	private String validateCode;
	private String errorMessage;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getValidateCode() {
		return validateCode;
	}
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
