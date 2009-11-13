package com.bird.service.impl;

import java.util.List;

import com.bird.domain.UserBean;
import com.bird.service.SuperService;
import com.bird.service.UserService;

public class UserServiceImpl extends SuperService implements UserService {

	public int deleteObject(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getObject(Object o) {
		return getUserDao().getObject(o);
	}

	public List<UserBean> getObjectList(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertObject(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
