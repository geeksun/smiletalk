package com.bird.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.bird.dao.FollowDao;
import com.bird.domain.Follow;
import com.ibatis.sqlmap.client.SqlMapClient;

public class FollowDaoImpl implements FollowDao{
	private SqlMapClient sqlMapClient;
	
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	
	/**
	 *  返回用户ID和关注者的ID列表
	 */
	/*public List<Follow> getUserIdList(Follow follow) {*/
	public List<Long> getUserIdList(Follow follow) {
		try {
			/*List<Follow> userIdList = (List<Follow>) sqlMapClient.queryForList("findUserIdList", follow);*/
			List<Long> userIdList = (List<Long>) sqlMapClient.queryForList("findUserIdList", follow);
			return userIdList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
