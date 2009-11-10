package com.bird.service;

import java.util.List;

public interface TopicService {
	
	public int insertObject(Object o);
	public List<Object> getObjectList();
	public Object getObject();
	public int deleteObject(Object o);
	
	
}
