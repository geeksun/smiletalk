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

	public List<UserBean> getObjectList(Object o) {
		return null;
	}

	public int insertObject(Object o) {
		return userDao.insertObject(o);
	}

	/**
	 * @see com.bird.service.UserService#loginUser(com.bird.vo.UserVo)
	 * ��¼��֤
	 */
	public UserBean loginUser(UserBean userBean) {
		if(userBean==null){
			return null;
		}
		//��domain object����po��vo,ʡȥ��������Ĳ���
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
	

}
