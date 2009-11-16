package com.bird.dao;

import java.util.List;

import com.bird.domain.UserBean;

public interface UserDao {
	public int insertObject(Object o);
	public List<UserBean> getObjectList(Object o);
	public Object getObject(Object o);
	public int deleteObject(Object o);
	public UserBean loginUser(UserBean userBean);
}
