package com.bird.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.bird.dao.TopicDao;
import com.bird.domain.TopicBean;
import com.bird.util.DateUtil;

public class TopicDaoImpl implements TopicDao {
	private Connection con;
	
	public Connection getConnection() {
		return con;
	}

	public void setConnection(Connection conn) {
		this.con = conn;
	}

	public int deleteObject(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getObject() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object> getObjectList() {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertObject(Object o) {
		TopicBean topic = (TopicBean) o;
		String exe_sql = "insert topic (username,topicContent,userid,topicTime) values (?,?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(exe_sql);
			pst.setString(1, topic.getUserName());
			pst.setString(2, topic.getTopicContent());
			pst.setLong(3, topic.getUserId());
			Date d = new Date();
			String topicTime = DateUtil.getDateString(d);
			pst.setString(4,  topicTime);
			return pst.executeUpdate();
		} catch (SQLException e) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			e.printStackTrace();
		}
		return 0;
	}

}
