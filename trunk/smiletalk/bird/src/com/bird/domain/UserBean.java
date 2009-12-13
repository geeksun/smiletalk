package com.bird.domain;

import java.io.Serializable;
import java.util.List;

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
	// 关注者ID
	private Long followUserId;
	private String userName;
	private String password;
	private String email;
	private String isActive;	// 激活状态-0:未激活1：激活
	private String validateCode;
	private String regTime;
	private String errorMessage;
	private String photoPath;	// 头像地址
	private String birthday;
	private String sex;
	private String region;		// 地区
	
	/*private List<TopicBean> topicList;	// 用户对应的topic列表, 一对多*/
	private TopicBean topicBean;	// 用户对应的最新发言记录
	
	
	public TopicBean getTopicBean() {
		return topicBean;
	}
	public void setTopicBean(TopicBean topicBean) {
		this.topicBean = topicBean;
	}
	/*public List<TopicBean> getTopicBean() {
		return topicList;
	}
	public void setTopicBean(List<TopicBean> topicList) {
		this.topicList = topicList;
	}*/
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
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
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public Long getFollowUserId() {
		return followUserId;
	}
	public void setFollowUserId(Long followUserId) {
		this.followUserId = followUserId;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	
}
