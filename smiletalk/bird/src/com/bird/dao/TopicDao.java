package com.bird.dao;

import java.util.List;

import com.bird.domain.TopicBean;

public interface TopicDao {
	
	public int insertObject(Object o);
	public List<TopicBean> getObjectList(TopicBean o);
	public TopicBean getRecentTopic(TopicBean o);
	public int deleteObject(Object o);
	public List<TopicBean> getRandomBrowseList();
	
	
}
