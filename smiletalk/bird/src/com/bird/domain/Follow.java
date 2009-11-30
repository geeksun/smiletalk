package com.bird.domain;

import java.io.Serializable;

/**
 * 用户和关注者ID关联
 * @author 姜志强
 * 2009-11-30
 */
public class Follow implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7030269529758872330L;
	private Long id;
	private Long userId;
	private Long followId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getFollowId() {
		return followId;
	}
	public void setFollowId(Long followId) {
		this.followId = followId;
	}

}
