package com.bird.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author jzq
 *  话题BEAN
 *  2009-11-3
 */
public class TopicBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3210689259419767229L;
	private Long userId;
	// 关注者ID
	private Long followUserId;
	private String userName;
	private String topicContent;
	private String topicTime;
	//	用户ID和关注者的List
	private List<Long> userIdList;
	
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
	public Long getFollowUserId() {
		return followUserId;
	}
	public void setFollowUserId(Long followUserId) {
		this.followUserId = followUserId;
	}
	public List<Long> getUserIdList() {
		return userIdList;
	}
	public void setUserIdList(List<Long> userIdList) {
		this.userIdList = userIdList;
	}
	
	
}
