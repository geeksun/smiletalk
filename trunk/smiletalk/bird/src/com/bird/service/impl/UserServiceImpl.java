package com.bird.service.impl;

import java.util.List;

import javax.mail.MessagingException;

import com.bird.dao.FollowDao;
import com.bird.dao.UserDao;
import com.bird.domain.Follow;
import com.bird.domain.UserBean;
import com.bird.service.SuperService;
import com.bird.service.UserService;
import com.bird.util.MailSenderUtil;

public class UserServiceImpl extends SuperService implements UserService {
	private UserDao userDao;
	private FollowDao followDao;
	
	public void setFollowDao(FollowDao followDao) {
		this.followDao = followDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public int deleteObject(Object o) {
		return 0;
	}

	/**
	 *  �ж��û����Ƿ�Ψһ
	 */
	public Object getObject(Object o) {
		return userDao.getObject(o);
	}
	
	/**
	 * @see �ж�email�Ƿ�Ψһ
	 */
	public Object getUserByEamil(Object o){
		return userDao.getUserByEamil(o);
	}

	/**
	 * @see com.bird.dao.UserDao#getObjectList(java.lang.Object)
	 * �����û����ҳ��û����б�ģ����ѯ
	 */
	public List<UserBean> getObjectList(Object o) {
		return userDao.getObjectList(o);
	}

	public int insertObject(Object o) {
		return userDao.insertObject(o);
	}

	/**
	 * ��¼��֤
	 */
	public UserBean loginUser(UserBean userBean) {
		if(userBean==null){
			return null;
		}
		return userDao.loginUser(userBean);
	}

	public UserBean getUserById(UserBean userBean) {
		if(userBean==null){
			return null;
		}
		return userDao.getUserById(userBean);
	}

	/**
	 *  �����û��Ĺ�ע�ߵ�ID�б�
	 */
	public List<Long> getUserIdList(Follow follow) {
		if(follow==null){
			return null;
		}
		return followDao.getUserIdList(follow);
	}

	/**
	 * �����û�������Ϣ
	 */
	public int updateSettingsInfo(UserBean userBean) {
		if(userBean==null)
			return 0;
		int result = userDao.updateSettingsInfo(userBean);
		return result;
	}

	/**
	 *  �����û������ʼ�
	 */
	public void sendActivateEmail(UserBean userBean) throws MessagingException {
		if(userBean==null){
			return;
		}
		int flag = MailSenderUtil.sendActivateEmail(userBean);
		if(flag>0){
			userDao.updateObject(userBean);
		}
	}

	/**
	 *  �����û��һ������ʼ�
	 */
	public void sendForgetDisposeEmail(UserBean userBean) {
		if(userBean==null){
			return;
		}
		int flag = MailSenderUtil.sendForgetDisposeEmail(userBean);
		if(flag>0){
			userDao.updateObject(userBean);
		}
	}
	
	
}
