package com.bird.service.impl;

import java.util.List;
import com.bird.domain.TopicBean;
import com.bird.service.SuperService;
import com.bird.service.TopicService;

public class TopicServiceImpl extends SuperService implements TopicService{

	public int deleteObject(Object o) {
		return 0;
	}

	public int insertObject(Object o) {
		return getTopicDao().insertObject(o);
	}

	public Object getObject(Object o) {
		return null;
	}

	public List<TopicBean> getObjectList(Object o) {
		return getTopicDao().getObjectList(o); 
	}
	
	
}
