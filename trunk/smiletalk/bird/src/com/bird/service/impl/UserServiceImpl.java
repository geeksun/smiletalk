package com.bird.service.impl;

import java.util.List;

import javax.mail.MessagingException;

import com.bird.dao.UserDao;
import com.bird.domain.UserBean;
import com.bird.service.SuperService;
import com.bird.service.UserService;
import com.bird.util.MailSenderUtil;

public class UserServiceImpl extends SuperService implements UserService {
	private UserDao userDao;
	
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

	public List<UserBean> getObjectList(Object o) {
		return null;
	}

	public int insertObject(Object o) {
		return userDao.insertObject(o);
	}

	/**
	 * @see com.bird.service.UserService#loginUser(com.bird.vo.UserVo)
	 * 登录验证
	 */
	public UserBean loginUser(UserBean userBean) {
		if(userBean==null){
			return null;
		}
		//用domain object代替po和vo,省去两个对象的操作
		/*UserPo userPo = new UserPo();
		PropertyUtils.copyProperties(userPo, userVo);
		userPo = userDao.loginUser(userPo);
		if(userPo!=null){
			PropertyUtils.copyProperties(userVo, userPo);
		}*/
		userBean = userDao.loginUser(userBean);
		return userBean;
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
	

}
