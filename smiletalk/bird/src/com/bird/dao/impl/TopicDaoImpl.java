package com.bird.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.bird.dao.TopicDao;
import com.bird.domain.TopicBean;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * italk ���⡢����
 * @author ��־ǿ
 * 2009-12-12
 */
public class TopicDaoImpl  implements TopicDao {
	private SqlMapClient sqlMapClient;
	
	
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	
	public int deleteObject(Object o) {
		
		return 0;
	}

	public Object getObject() {
		
		return null;
	}

	/**
	 * @see com.bird.dao.TopicDao#getObjectList(com.bird.domain.TopicBean)
	 *  ��ȡtopic��¼�����û���ID�������ж��ID��
	 */
	public List<TopicBean> getObjectList(TopicBean topicBean) {
		try {
			List<TopicBean> topicList = (List<TopicBean>)sqlMapClient.queryForList("findTopicByUser", topicBean.getUserIdList());
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

	/**
	 * @see com.bird.dao.TopicDao#getRandomBrowseList()
	 * ��ȡ�����topic��¼
	 */
	public List<TopicBean> getRandomBrowseList() {
		try {
			List<TopicBean> topicList = (List<TopicBean>)sqlMapClient.queryForList("findRandomTopicList");
			return topicList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	

}
