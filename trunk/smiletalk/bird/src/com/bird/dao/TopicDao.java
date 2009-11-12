package com.bird.dao;

import java.util.List;

import com.bird.domain.TopicBean;

public interface TopicDao {
	
	public int insertObject(Object o);
	public List<TopicBean> getObjectList(Object o);
	public Object getObject();
	public int deleteObject(Object o);
	
	
}
