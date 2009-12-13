package com.bird.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.bird.dao.UserDao;
import com.bird.domain.FollowBean;
import com.bird.domain.TopicBean;
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

	/**
	 * @see com.bird.dao.UserDao#getObjectList(java.lang.Object)
	 * 根据用户名找出用户的列表：模糊查询
	 */
	public List<UserBean> getObjectList(Object o) {
		if(o==null){
			return null;
		}
		UserBean userBean = (UserBean) o;
		try {
			List<UserBean> userList = (List<UserBean>)sqlMapClient.queryForList("findUserListByName", userBean);
			return userList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	 *  用户登录验证：用户名、密码
	 */
	public UserBean loginUser(UserBean userBean) {
        try {
        	UserBean usrBean = (UserBean)sqlMapClient.queryForObject("findUserByName", userBean);
        	if(usrBean!=null){
        		if(usrBean.getPassword().equals(userBean.getPassword())){
        			return usrBean;
        		}
        		return null;
        	}
			return null;
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

	/**
	 * 更新用户设置信息
	 */
	public int updateSettingsInfo(UserBean userBean) {
		try {
        	int result = (Integer)sqlMapClient.update("updateSettingsInfo", userBean);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}



	

}
