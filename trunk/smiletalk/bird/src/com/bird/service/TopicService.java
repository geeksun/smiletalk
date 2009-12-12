package com.bird.service;

import java.util.List;

import com.bird.domain.TopicBean;

public interface TopicService {
	
	public int insertObject(Object o);
	public List<TopicBean> getObjectList(TopicBean o);
	public Object getObject(Object o);
	public int deleteObject(Object o);
	public List<TopicBean> getRandomBrowseList();
	
	
}
