package com.bird.service;

import javax.sql.DataSource;

import com.bird.dao.impl.TopicDaoImpl;
import com.bird.db.DBConnection;


/**
 * @author jzq
 *  service ≥¨¿‡
 *  2009-11-10
 */
public class SuperService {
	
	private TopicDaoImpl topicDao;
	
	public SuperService() {
		super();
		topicDao = new TopicDaoImpl();
		
	}
	
	public TopicDaoImpl getTopicDao() {
		return topicDao;
	}

	public void setTopicDao(TopicDaoImpl topicDao) {
		this.topicDao = topicDao;
	}


	
	
	
}
