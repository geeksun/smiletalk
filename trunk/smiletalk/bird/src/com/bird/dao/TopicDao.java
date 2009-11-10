package com.bird.dao;

import java.util.List;

public interface TopicDao {
	
	public int insertObject(Object o);
	public List<Object> getObjectList();
	public Object getObject();
	public int deleteObject(Object o);
	
	
}
