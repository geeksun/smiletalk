package com.bird.dao;

import java.util.List;

import com.bird.domain.Follow;

public interface FollowDao {
	public List<Long> getUserIdList(Follow follow);
	

}