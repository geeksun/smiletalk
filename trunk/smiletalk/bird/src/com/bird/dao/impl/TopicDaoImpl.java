package com.bird.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.bird.dao.TopicDao;
import com.bird.domain.TopicBean;
import com.ibatis.sqlmap.client.SqlMapClient;

public class TopicDaoImpl  implements TopicDao {
	private SqlMapClient sqlMapClient;
	
	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	
	public int deleteObject(Object o) {
		
		return 0;
	}

	public Object getObject() {
		
		return null;
	}

	public List<TopicBean> getObjectList(TopicBean topicBean) {
		try {
			List<TopicBean> topicList = (List<TopicBean>)this.sqlMapClient.queryForList("findTopicByUser", topicBean);
			return topicList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;		
	}

	public int insertObject(Object o) {
		TopicBean topic = (TopicBean) o;
		try {
        	//int result = (Integer)sqlMapClient.insert("insertTopic", topic);
			sqlMapClient.insert("insertTopic", topic);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	

}
