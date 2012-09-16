package com.bird.dao.impl;

import java.sql.SQLException;

import com.bird.dao.LogDao;
import com.bird.domain.LogBean;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * Description 日志DAO操作类
 * @author Administrator
 * 2012-9-16
 */
public class LogDaoImpl implements LogDao {
	
	private SqlMapClient sqlMapClient;
	
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	@Override
	public void addLog(LogBean log) {
		try {
        	sqlMapClient.insert("addLog", log);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
