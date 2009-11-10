package com.bird.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.bird.service.SuperService;
import com.bird.service.TopicService;

public class TopicServiceImpl extends SuperService implements TopicService{

	public int deleteObject(Object o) {
		return 0;
	}

	public int insertObject(Object o) {
		Connection conn = null;
		try {
			conn = this.getDataSource().getConnection();
			conn.setAutoCommit(false);					
			this.getTopicDao().setConnection(conn);
			int i = getTopicDao().insertObject(o);
			conn.commit();
			return i;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public Object queryObject() {
		return null;
	}

	public Object getObject() {
		return null;
	}

	public List<Object> getObjectList() {
		return null;
	}
	
	
}
