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
	 *  �ж��û����Ƿ�Ψһ
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
	 *  �ж��ʼ��Ƿ�Ψһ
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
	 * �����û����ҳ��û����б�ģ����ѯ
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
	 *  �������û�
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
	 *  �û���¼��֤���û���������
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
	 *  �����û�״̬��д���û�����֤��
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
	 *  ��ȡ�û���Ϣ
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
	 * �����û�������Ϣ
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
