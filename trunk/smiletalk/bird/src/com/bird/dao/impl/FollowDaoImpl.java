package com.bird.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.bird.dao.FollowDao;
import com.bird.domain.FollowBean;
import com.ibatis.sqlmap.client.SqlMapClient;

public class FollowDaoImpl implements FollowDao{
	private SqlMapClient sqlMapClient;
	
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	
	/**
	 *  返回用户ID和关注者的ID列表
	 */
	public List<Long> getUserIdList(FollowBean follow) {
		try {
			List<Long> userIdList = (List<Long>) sqlMapClient.queryForList("findUserIdList", follow);
			return userIdList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 *  增加follow记录
	 */
	public int insertFollow(FollowBean followBean) {
		try {
        	sqlMapClient.insert("insertFollow", followBean);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
