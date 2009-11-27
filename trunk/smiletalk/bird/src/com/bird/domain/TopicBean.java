package com.bird.domain;

import java.io.Serializable;

/**
 * @author jzq
 *  ����BEAN
 *  2009-11-3
 */
public class TopicBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3210689259419767229L;
	private Long userId;
	private String userName;
	private String topicContent;
	private String topicTime;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTopicContent() {
		return topicContent;
	}
	public void setTopicContent(String topicContent) {
		this.topicContent = topicContent;
	}
	public String getTopicTime() {
		return topicTime;
	}
	public void setTopicTime(String topicTime) {
		this.topicTime = topicTime;
	}
	
	
}
