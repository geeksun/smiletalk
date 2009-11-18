package com.bird.service;

import java.util.List;

import javax.mail.MessagingException;

import com.bird.domain.UserBean;

public interface UserService {
	public int insertObject(Object o);
	public List<UserBean> getObjectList(Object o);
	public Object getObject(Object o);
	public Object getUserByEamil(Object o);
	public int deleteObject(Object o);
	public UserBean loginUser(UserBean userBean);
	public void sendActivateEmail(UserBean userBean) throws MessagingException;
	
}
