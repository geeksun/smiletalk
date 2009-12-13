package com.bird.dao;

import java.util.List;

import com.bird.domain.FollowBean;

public interface FollowDao {
	public List<Long> getUserIdList(FollowBean follow);
	public int insertFollow(FollowBean followBean);
	

}
