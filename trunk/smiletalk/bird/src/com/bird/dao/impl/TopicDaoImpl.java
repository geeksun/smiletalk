package com.bird.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.bird.dao.TopicDao;
import com.bird.db.DBConnection;
import com.bird.domain.TopicBean;
import com.bird.util.DateUtil;
import com.ibatis.sqlmap.client.SqlMapClient;

public class TopicDaoImpl  implements TopicDao {
	private Connection con;
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
