package com.bird.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bird.dao.TopicDao;
import com.bird.db.DBConnection;
import com.bird.domain.TopicBean;
import com.bird.util.DateUtil;

public class TopicDaoImpl  implements TopicDao {
	private Connection con;
	
	public int deleteObject(Object o) {
		
		return 0;
	}

	public Object getObject() {
		
		return null;
	}

	public List<TopicBean> getObjectList(Object o) {
		TopicBean topic = (TopicBean) o;
		List<TopicBean> topicList = new ArrayList<TopicBean>();
		String next_sql = "select * from topic t where t.userId = ?";
		try {
			con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(next_sql);
			pst.setLong(1, topic.getUserId());
			ResultSet rs = pst.executeQuery();
			TopicBean tbean = null;
			while(rs.next()){
				tbean = new TopicBean();
				tbean.setUserName(rs.getString("userName"));
				tbean.setTopicContent(rs.getString("topicContent"));
				tbean.setTopicTime(rs.getString("topicTime"));
				topicList.add(tbean);
			}
			DBConnection.closeConnection(con);
			return topicList;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public int insertObject(Object o) {
		TopicBean topic = (TopicBean) o;
		String exe_sql = "insert topic (username,topicContent,userid,topicTime) values (?,?,?,?)";
		try {
			con = DBConnection.getConnection();
			con.setAutoCommit(false);
			PreparedStatement pst = con.prepareStatement(exe_sql);
			pst.setString(1, topic.getUserName());
			pst.setString(2, topic.getTopicContent());
			pst.setLong(3, topic.getUserId());
			Date d = new Date();
			String topicTime = DateUtil.getDateString(d);
			pst.setString(4,  topicTime);
			int result = pst.executeUpdate();
			con.commit();
			DBConnection.closeConnection(con);
			return result;
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
