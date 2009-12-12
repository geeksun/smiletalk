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
	 *  判断用户名是否唯一
	 */
	public Object getObject(Object o) {
		return userDao.getObject(o);
	}
	
	/**
	 * @see 判断email是否唯一
	 */
	public Object getUserByEamil(Object o){
		return userDao.getUserByEamil(o);
	}

	/**
	 * @see com.bird.dao.UserDao#getObjectList(java.lang.Object)
	 * 根据用户名找出用户的列表：模糊查询
	 */
	public List<UserBean> getObjectList(Object o) {
		return userDao.getObjectList(o);
	}

	public int insertObject(Object o) {
		return userDao.insertObject(o);
	}

	/**
	 * 登录验证
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
	 *  返回用户的关注者的ID列表
	 */
	public List<Long> getUserIdList(Follow follow) {
		if(follow==null){
			return null;
		}
		return followDao.getUserIdList(follow);
	}

	/**
	 * 更新用户设置信息
	 */
	public int updateSettingsInfo(UserBean userBean) {
		if(userBean==null)
			return 0;
		int result = userDao.updateSettingsInfo(userBean);
		return result;
	}

	/**
	 *  发送用户激活邮件
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
	 *  发送用户找回密码邮件
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
