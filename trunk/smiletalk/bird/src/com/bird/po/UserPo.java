package com.bird.po;

import java.io.Serializable;

/**
 * @author jzq
 * iTalk �û�
 * 2009-11-4
 */
public class UserPo  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1160813176895973180L;
	private long userId;
	private String userName;
	private String password;
	private String email;
	private String isActive;//����״̬-0:δ����1������
	private String validateCode;
	
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
