package com.bird.service;

import java.util.List;

import javax.mail.MessagingException;

import com.bird.domain.Follow;
import com.bird.domain.UserBean;

public interface UserService {
	public int insertObject(Object o);
	public List<UserBean> getObjectList(Object o);
	public Object getObject(Object o);
	public Object getUserByEamil(Object o);
	public int deleteObject(Object o);
	public UserBean loginUser(UserBean userVo);
	public void sendActivateEmail(UserBean user) throws MessagingException;
	public UserBean getUserById(UserBean userBean);
	
	/**
	 *  返回用户的关注者的ID列表
	 */
	public List<Long> getUserIdList(Follow follow);
	public int updateSettingsInfo(UserBean userBean);
	
}
