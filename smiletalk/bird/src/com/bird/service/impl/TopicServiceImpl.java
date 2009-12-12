package com.bird.service.impl;

import java.util.List;

import com.bird.dao.TopicDao;
import com.bird.domain.TopicBean;
import com.bird.service.SuperService;
import com.bird.service.TopicService;

public class TopicServiceImpl extends SuperService implements TopicService{
	private TopicDao topicDao;
	
	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}

	public int deleteObject(Object o) {
		return 0;
	}

	public int insertObject(Object o) {
		return topicDao.insertObject(o);
	}

	public Object getObject(Object o) {
		return null;
	}

	public List<TopicBean> getObjectList(TopicBean topicBean) {
		if(topicBean==null){
			return null;
		}
		List<TopicBean> topicBeanList = topicDao.getObjectList(topicBean);
		return topicBeanList;
	}

	public List<TopicBean> getRandomBrowseList() {
		return topicDao.getRandomBrowseList();
	}
	
	
}
