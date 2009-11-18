package com.bird.service.impl;

import java.util.List;
import com.bird.domain.UserBean;
import com.bird.util.MailSenderUtil;
import com.bird.service.UserService;
import com.bird.service.SuperService;
import javax.mail.MessagingException;

public class UserServiceImpl extends SuperService implements UserService {

	public int deleteObject(Object o) {
		return 0;
	}

	/**
	 *  �ж��û����Ƿ�Ψһ
	 */
	public Object getObject(Object o) {
		return getUserDao().getObject(o);
	}
	
	public Object getUserByEamil(Object o){
		return getUserDao().getUserByEamil(o);
	}

	public List<UserBean> getObjectList(Object o) {
		return null;
	}

	public int insertObject(Object o) {
		return getUserDao().insertObject(o);
	}

	public UserBean loginUser(UserBean userBean) {
		return getUserDao().loginUser(userBean);
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
			getUserDao().updateObject(userBean);
		}
	}
	

}
