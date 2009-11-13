package com.bird.service;

import com.bird.dao.TopicDao;
import com.bird.dao.UserDao;
import com.bird.dao.impl.TopicDaoImpl;
import com.bird.dao.impl.UserDaoImpl;


/**
 * @author jzq
 *  service ≥¨¿‡
 *  2009-11-10
 */
public class SuperService {
	
	private TopicDao topicDao;
	private UserDao userDao;
	
	public SuperService() {
		super();
		topicDao = new TopicDaoImpl();
		userDao = new UserDaoImpl();
	}
	
	public TopicDaoImpl getTopicDao() {
		return (TopicDaoImpl) topicDao;
	}

	public void setTopicDao(TopicDaoImpl topicDao) {
		this.topicDao = topicDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	
	
	
}
