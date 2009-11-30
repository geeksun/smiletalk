package com.bird.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.bird.dao.UserDao;
import com.bird.domain.UserBean;
import com.ibatis.sqlmap.client.SqlMapClient;

public class UserDaoImpl implements UserDao {
	private SqlMapClient sqlMapClient;
	
	
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public int deleteObject(Object o) {
		return 0;
	}

	/**
	 *  判断用户名是否唯一
	 */
	public Object getObject(Object o) {
		if(o==null){
			return null;
		}
		UserBean userBean = (UserBean) o;
		try {
        	UserBean usrBean = (UserBean)sqlMapClient.queryForObject("findUserByName", userBean);
			return usrBean;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 *  判断邮件是否唯一
	 */
	public Object getUserByEamil(Object o) {
		if(o==null){
			return null;
		}
		UserBean userBean = (UserBean) o;
		try {
        	UserBean usrBean = (UserBean)sqlMapClient.queryForObject("findUserByEmail", userBean);
			return usrBean;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<UserBean> getObjectList(Object o) {
		
		return null;
	}

	/**
	 *  增加新用户
	 */
	public int insertObject(Object o) {
		if(o==null){
			return 0;
		}
		UserBean userBean = (UserBean) o;
		try {
        	sqlMapClient.insert("insertUser", userBean);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 *  用户登录验证
	 */
	public UserBean loginUser(UserBean userBean) {
        try {
        	UserBean usrBean = (UserBean)sqlMapClient.queryForObject("loginUser", userBean);
			return usrBean;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *  更新用户状态：写入用户的验证码
	 */
	public void updateObject(UserBean userBean) {
		if(userBean==null){
			return;
		}
		try {
        	sqlMapClient.update("updateUserValidateCode", userBean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 *  提取用户信息
	 */
	public UserBean getUserById(UserBean userBean) {
		try {
        	UserBean usrBean = (UserBean)sqlMapClient.queryForObject("findUserById", userBean);
			return usrBean;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	

}
