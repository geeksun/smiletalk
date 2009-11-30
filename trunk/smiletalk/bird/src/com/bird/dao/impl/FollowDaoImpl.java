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
	 *  �����û�ID�͹�ע�ߵ�ID�б�
	 */
	public List<Long> getUserIdList(Follow follow) {
		try {
			List<Long> userIdList = (List<Long>) sqlMapClient.queryForList("findUserIdList", follow);
			return userIdList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
